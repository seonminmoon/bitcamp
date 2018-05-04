// 익명 객체
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {
    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-04.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        // 익명 객체의 경우 bitcamp.java106.step02.Car#0 라는 이름으로 저장됨.

        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Car#0");
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Car#1");
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Car#2");
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Car#3");
        
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Engine#0");
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Engine#1");
        BeanUtils.printBeanAliases(iocContainer,"bitcamp.java106.step02.Engine#2");
        
    }
}
