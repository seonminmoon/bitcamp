// @Component 애노테잉션이 붙은 클래스만 객체를 생성한다.
package step19.ex9;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationContext10 {
    
    private HashMap<String, Object> objPool = new HashMap<>();

    public ApplicationContext10(String packageName) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); 
        
        File dir = new File(classLoader.getResource(
                packageName.replace(".", "/")).getPath());
        // 패키지 이름으로 클래스 로더의 실제 자원경로를 알아낸다. 그리고 그 경로를 가지고 파일 생성
        
        if (!dir.isDirectory())
            return;
        
        findAndInstantiateClasses(dir, packageName);
        // 클래스를 찾아서 인스턴스를 생성한다.
    }
    
    private void findAndInstantiateClasses(File dir, String packageName) throws Exception { 
        File[] files = dir.listFiles(new FileFilter() { 
            // 익명클래스 FileFilter 생성
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || // 디렉토리 이거나 
                        (pathname.getName().endsWith(".class") && // 클래스 파일인 경우 
                        !pathname.getName().contains("$"))) { // 단, 중첩클래스는 제외
                    return true;
                }
                return false;
            }
        });
        for(File f : files) {       // 재귀호출
            if (f.isDirectory()) {
                findAndInstantiateClasses(f, packageName + "." + f.getName());
                continue;
            } 
            
            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." +
                    classname.substring(0, classname.length() - 6)); // ".class" 떼내기
            
            // 이미 해당 타입의 객체가 생성되어 있다면 다시 생성하지 않는다.
            if (objPool.get(clazz.getName()) != null)
                continue;
            
            Object obj = createObject(clazz); // 객체 생성해서 리턴
            if(obj != null) {
                this.objPool.put(getComponentName(clazz), obj); // 클래스 이름으로 객체를 저장(put)하겠다.
            }
        }
    }
    
    private String getComponentName(Class clazz) throws Exception {
        Component anno = (Component) clazz.getAnnotation(Component.class);
        String label = anno.value();
        if (label.length() == 0)
            return clazz.getName();
        return label;
    }
    
    private Object createObject(Class clazz) throws Exception {
       
        if(!isComponent(clazz)) // @Component 붙은것만 실행
            return null;
        
        try { 
            // 파라미터가 없는 기본 생성자를 찾는다.
            clazz.getConstructor();
            return clazz.newInstance(); // 기본 생성자를 호출하여 객체를 생성한다.
        } catch (Exception e) { 
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Object obj = callConstructor(constructor);
                if (obj != null)
                    return obj;
            }
            return null;
        }
    }
    
    private boolean isComponent(Class clazz) throws Exception { 
        // 애노테이션의 타입을 지정하여 해당 클래스에서 그 애노테이션 정보를 추출한다.
        Component anno = (Component) clazz.getAnnotation(Component.class);
        if (anno == null)
            return false;
        return true; // 애노테이션 표시가 붙은 클래스만 관리하겠다!!
    }
    
    private Object callConstructor(Constructor constructor) throws Exception {
        if (containsDefaultType(constructor))
            return null;
        
        // 생성자의 파라미터 타입을 알아낸다.
        Class[] paramTypes = constructor.getParameterTypes();
        
        // 파라미터 타입에 해당하는 값을 보관할 저장소
        ArrayList<Object> paramValues = new ArrayList<>();
        for(Class paramType : paramTypes) {
           paramValues.add(findObject(paramType)); // 파라미터값 준비
           
        }
        
        // 파라미터값이 준비되었기 때문에
        // 준비한 파라미터 값을 가지고 생성자를 호출하여 인스터스를 만들어 리턴한다.
        return constructor.newInstance(paramValues.toArray());
    }
    
    private Object findObject(Class clazz) throws Exception {
        Object obj = objPool.get(clazz.getName());
        if (obj != null) { // 그 클래스 타입과 일치하는 객체가 있다면 찾은 객체 리턴 
            return obj; 
        }   
        
        // 만약 objPool에 그런 타입의 객체가 없다면? 새로 만들어서 보관하고 리턴
        obj = clazz.newInstance();
        objPool.put(clazz.getName(), obj);
        return obj;
        
    }
    private boolean containsDefaultType(Constructor constructor) {
        Class[] defaultTypes = { // 의존객체가 아닌 경우는 제외하기
                byte.class, short.class,int.class, long.class, float.class, double.class,
                boolean.class, char.class, Byte.class,Short.class,Long.class,Float.class,
                Double.class, Boolean.class, Character.class, String.class
        };
        
        //1) 생성자의 파라미터 정보 꺼냄
        Class[] paramTypes = constructor.getParameterTypes();
        
        // 2) 생성자의 파라미터 타입이 primitive 타입이거나 Wrapper, String 일 경우
        //    이 생성자를 호출할 때 해당값을 줘서 호출해야 한다.
        //    문제는 어떤 값을 줘야 하는지, 예를 들어 int를 원한다면
        //    int 값으로 얼마를 줘야하는지 여기서 결정할 수 없다.
        //    그래서 이런 생성자로는 객체를 생성할 수 없다.
        //    이런 생성자인지 검사한다.
        for (Class paramType : paramTypes) {
            for (Class defaultType : defaultTypes) {
                if (paramType == defaultType)
                    return true;
            }
        }
        return false;
    }
    
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    public void print() {
        
    }
}