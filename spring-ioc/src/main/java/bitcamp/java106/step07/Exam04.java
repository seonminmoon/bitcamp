// 프로퍼티 에디터 - String ==> Engine  강사님주석(Utils도)
package bitcamp.java106.step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step07/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }

}





