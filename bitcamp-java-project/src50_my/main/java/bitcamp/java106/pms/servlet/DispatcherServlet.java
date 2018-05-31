// 프론트 컨트롤러 구현 
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.web.RequestMapping;
import bitcamp.java106.pms.web.RequestParam;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // Front Controller
        // => 클라이언트의 모든 요청을 받아서 특정 컨트롤러에게 위임하기 전에 
        //    필요한 공통 기능 처리한다.
        // => 클라이언트의 진입점이 한 군데라서 유지보수가 용이하다.
        response.setContentType("text/html;charset=UTF-8");
        
        // 클라이언트가 요청한 서블릿의 경로를 알아내기
        String servletPath = request.getServletPath().replace(".do", "");
        
        // servletPath 에서 객체명 추출하기
        // => 즉 맨 끝 / 이후의 문자열을 제외한 이름
        // => 예) /board/add ===> /board
        int index = servletPath.lastIndexOf('/');
        String objName = servletPath.substring(0, index);
        String handlerPath = servletPath.substring(index); // 인덱스부터 끝까지 (=add,delete..)
        
        // 페이지 컨트롤러 실행
        try {
            // 클라이언트가 요청을 처리할 페이지 컨트롤러를 얻기
            Object pageController = iocContainer.getBean(objName);
            
            // 클라이언트 요청을 처리하는 메서드(request handler)를 알아낸다.
            Method requestHandler = findRequestHandler(pageController, handlerPath);
            if (requestHandler == null) {
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            }
            
            // 요청 핸들러가 리턴해줄 값을 담을 바구니를 준비한다.
            HashMap<String,Object> resultMap = new HashMap<>();
            
            // 요청 핸들러의 파라미터 값을 준비한다.
            Object[] paramValues = prepareParamValues(
                            requestHandler, request, response, resultMap);
            
            // 준비한 파라미터 값을 가지고 요청 핸들러를 호출한다.
            String viewUrl = (String)requestHandler.invoke(
                                    pageController, paramValues);
            
            // 요청 핸들러를 실행한 후,
            // 요청 핸들러가 저장한 작업 결과가 담겨 있는 resultMap의 값들을 ServletRequest로 옮긴다.
            // 왜?
            // JSP가 꺼내 쓸 수 있도록 하기 위함.
            Set<String> keySet = resultMap.keySet();
            for (String key : keySet) {
                request.setAttribute(key, resultMap.get(key));
            }
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!", e);
        }
    }


    private Object[] prepareParamValues(
            Method requestHandler,
            HttpServletRequest request,
            HttpServletResponse response,
            HashMap<String, Object> resultMap) {
        
        // 파라미터 값을 저장할 바구니 준비
        ArrayList<Object> paramValues = new ArrayList<>();
        
        // 메서드의 모든 파라미터 정보 알아내서 배열에 담기
        Parameter[] params = requestHandler.getParameters();
        
        // 배열에 담은 파라미터 정보들을 하나씩 꺼내서 조사하기
        for (Parameter p : params) {
            if (p.getType() == Map.class) {
                // 파라미터가 맵을 요구한다면, 우리는 resultMap을 리턴할것이다.
                paramValues.add(resultMap);
            } else if (p.getType() == HttpServletRequest.class) {
                // 파라미터가 HttpServletRequest을 요구한다면, 우리는 request을 리턴할것이다.
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) {
                // 파라미터가 HttpServletResponse을 요구한다면, 우리는 response을 리턴할것이다.
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (isPrimitiveType(p.getType())) {
                // 파라미터 타입이 프리머티브 타입이라면, 파라미터의 애노테이션 이름으로 request 한 값을
                // 프리머티브 타입으로 바꿔서 paramValues 배열에 저장한다.
                paramValues.add(getRequestParamValue(p, request));
            } else {
                paramValues.add(getValueObject(p, request));
            }
        }
        
        return paramValues.toArray();
        // 설정된 파라미터 값을 모두 담아서 최종적으로 배열로 리턴해준다.
    }

    private Object getValueObject(Parameter p, HttpServletRequest request) {
        Class<?> clazz = p.getType();
        try {
            Constructor<?> defaultconstructor = clazz.getConstructor();
            // 빈 Constructor 객체를 만들어서,
            Object valueObject = defaultconstructor.newInstance();
            
            Method[] methods = clazz.getMethods();
            // 메서드들을 준비한다.
            
            for (Method m : methods) {
                if (!m.getName().startsWith("set")) continue;
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
                
                // 클라이언트가 그 프로퍼티 이름으로 보낸 값이 없으면 건너 뛴다.
                if (propValue == null) continue;
                
                // 셋터에서 요구하는 파라미터 값의 타입이 String이나 primitive 타입이 아니면 건너 뛴다.
                Class<?> setterParamType = m.getParameterTypes()[0];
                if (!isPrimitiveType(setterParamType)) continue;
                
                // 셋터 메서드를 호출하여 클라이언트가 보낸 값을 저장한다.
                m.invoke(valueObject, toPrimitiveValue(propValue, setterParamType));
                
            }
            return valueObject;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getPropertyName(String methodName) { // 셋터겟터 이름 뽑아내기
        // setFirstName ==> FirstName 추출
        StringBuffer buf = new StringBuffer(methodName.substring(3));
        
        // 첫번째 알파벳을 소문자로 변경
        buf.setCharAt(0, Character.toLowerCase(buf.charAt(0)));
        
        return buf.toString();
    }

    private Object getRequestParamValue(Parameter p, HttpServletRequest request) {
        // int no = Integer.parseInt(request.getParameter("no")); 소스코드 등을 자동으로 처리함
        // delete, update 등 메서드의 파라미터 (@RequestParam("no") int no) 처리!
        
        // @RequestParam 애노테이션 정보를 추출한다. --> @RequestParam("no")
        RequestParam anno = p.getAnnotation(RequestParam.class);
        
        // 애노테이션 정보로부터 파라미터 이름을 꺼낸다.
        String paramName = anno.value();
        
        // 파라미터 이름을 사용하여 클라이언트가 보낸 데이터의 값을 꺼낸다.
        String value = request.getParameter(paramName);
        
        if (value == null) return null;
        
        // 클라이언트가 보낸 값은 문자열인데 그 문자열을 파라미터의 primitive 타입으로 바꿔서 리턴한다.
        return toPrimitiveValue(value, p.getType());
    }
    
    private Object toPrimitiveValue(String value, Class<?> type) {
        if (type == byte.class) return Byte.parseByte(value);
        if (type == short.class) return Short.parseShort(value);
        if (type == int.class) return Integer.parseInt(value);
        if (type == long.class) return Long.parseLong(value);
        if (type == float.class) return Float.parseFloat(value);
        if (type == double.class) return Double.parseDouble(value);
        if (type == char.class) return value.charAt(0);
        if (type == boolean.class) return Boolean.parseBoolean(value);
        if (type == Date.class) return Date.valueOf(value);
        
        return value;
    }
    
    
    
    private boolean isPrimitiveType(Class<?> type) {
        if (type == byte.class ||
            type == short.class ||
            type == int.class ||
            type == long.class ||
            type == float.class ||
            type == double.class ||
            type == char.class ||
            type == boolean.class ||
            type == String.class ||
            type == Date.class)
            return true;
        return false;
    }


    private Method findRequestHandler(Object pageController, String handlerPath) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null && anno.value().equals(handlerPath))
                return m;
        }
        return null;
        
    }
}

//ver 45 - 클래스 추가



