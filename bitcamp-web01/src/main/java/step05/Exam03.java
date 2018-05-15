// 파일 업로드 - 멀티파트 파라미터 값 추출하기
package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step05/exam02")
public class Exam03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법:
        // http://localhost:8888/java106-web01/step05/exam02_test.html
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        try {
            Map<String,List<FileItem>> paraMap = upload.parseParamterMap(request);
            
            for (FileItem item : items) {
                if (item.isFormField()) { // 일반적인 텍스트 항목일 경우,
                    // 파라미터의 한글이 깨질 경우,
                    // => request.setCharacterEncoding("UTF-8") 은 소용없다.
                    //    이 코드는 멀티파트가 아닌 application/x-www-form-urlencoded로 전송된
                    //    데이터에 대해서만 동작한다.
                    // => 해결책? getString(문자표) 를 호출하라!
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명  
                            item.getString("UTF-8")); // 파라미터 값 
                } else { // 파일일 경우, 
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명
                            item.getName()); // 파일명
                    // 클라이언트가 보낸 파일을 저장하자!
                    // - 임의의 폴더에 저장하면 웹 브라우저에서 업로드한 파일을 다시 다운로드 받기 어렵다.
                    //   임의의 폴더? 웹브라우저에서 접근할 수 없는 폴더를 말한다.
                    // - 임의의 폴더에 저장할 경우, 다운로드를 처리해주는 서블릿을 별도로 만들어야 한다.
                    // 좀 더 쉬운 방법은?
                    // - 웹브라우저가 접근할 수 있는 폴더에 저장하자!
                    // - 단 이 방법은 웹브라우저에서 너무 쉽게 특정 파일을 접근할 수 있기 때문에 
                    //   보안에 취약하다.
                    // 실무는 어떤 방식을 취하나?
                    // - 웹브라우저가 접근할 수 없는 곳에 저장한다.
                    // - 오직 다운로드 서블릿을 통해서만 허가된 사용자가 다운로드 받을 수 있도록 한다.
                    // 
                    // 여기서는 파일업로드 다운로드를 테스트하는데 집중하기 위해서 
                    // 임의의 폴더가 아닌 웹브라우저에서 접근할 수 있는 폴더에 저장하겠다.
                    // 즉 배치 폴더에서 저장하겠다.
                    // 배치 폴더에 저장하기 위해서는 배치 폴더의 전체 경로를 알아야 한다.
                    //
                    // => 웹 애플리케이션 환경 정보를 다루는 객체를 얻는다.
                    ServletContext appEnvInfo = request.getServletContext();
                    // => ServletContext 객체를 통해 웹 애플리케이션의 루트 디렉토리의 
                    //    실제 경로를 알아낸다.
                    String savedPath = appEnvInfo.getRealPath("/");
                    out.println(savedPath);
                    
                    // => FileItem.write(저장할 경로) 호출하여 클라이언트가 보낸 파일을 저장한다.
                    // => 업로드한 파일은 임시폴더에 저장되어 있다.
                    //    이 파일을 우리가 원하는 경로로 옮기는 것이다.
                    item.write(new File(savedPath + "/" + item.getName()));
                }
            }
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
    }
}







