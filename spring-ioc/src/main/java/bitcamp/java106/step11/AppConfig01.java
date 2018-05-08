package bitcamp.java106.step11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages="bitcamp.java106.step11",
        excludeFilters=@ComponentScan.Filter(
                type=FilterType.REGEX,
                pattern="bitcamp.java106.step11.b.*")
)       // step11에 있는 클래스 전부 호출할건데 단, b 패키지에 있는 클래스는 제외한다.

public class AppConfig01 {
    @Bean
    public Car car2() { 
        // Car 객체의 메서드를 생성하는데, car2 라는 이름으로 Bean에 저장해줘!
        Car c = new Car(null);
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(890);
        c.setAuto(true);
        return c;
    }
}
