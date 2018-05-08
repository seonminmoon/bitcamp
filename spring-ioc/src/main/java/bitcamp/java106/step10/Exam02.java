// 클래스를 이용하여 Spring 설정하기 - @Configration 애노테이션
package bitcamp.java106.step10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {
    public static void main(String[] args) {
        // 패키지명을 지정하면
        // 해당 패키지의 모든 클래스를 찾아 @Component, @Service, @Controller, @Repository
        // 애노테이션이 붙은 클래스에 대해 객체를 자동 생성한다.
        // 또한,
        // @Configuration 애노테이션이 붙은 클래스를 찾아
        // 그 클래스에 @Bean 애노테이션이 붙은 메서드를 호출하여 그 리턴 값을 저장한다.
        //
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(
                        "bitcamp.java106.step10"); 
        // 클래스 이름 말고 패키지 이름을 줘도 된다.
        // 대신, 애노테이션이 붙은 클래스를 @Configuration 를 통해서 알려줘야 한다. -> AppConfig02 참고
        
        BeanUtils.printBeanNames(iocContainer);
    }
}
