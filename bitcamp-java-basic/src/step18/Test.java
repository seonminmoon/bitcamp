package step18;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
    public void m1(String name, int age) {}
    public void m2() {}
    public void m3(File file, String name) {}
    public static void main(String[] args) throws Exception {
    
        Class clazz = Test.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.printf("%s: \n", m.getName());
            
            Parameter[] parameters = m.getParameters();
            for (Parameter p : parameters) {
                System.out.printf("    %s : %s \n",
                        p.getName(), p.getType().getName());
            }
        }
    }
}
