// 프로퍼티 호출 - 객체 주입 시 객체 생성 순서
package bitcamp.java106.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {
    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step04/application-context-04.xml");
        
    }
}
