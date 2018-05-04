// 팩토리 메서드 호출 - static 메서드 호출 응용
package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {
    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step06/application-context-02.xml");
        
        System.out.println(iocContainer.getBean("d1"));
        
    }
}
