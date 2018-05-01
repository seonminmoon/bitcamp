// 강사님 주석
package bitcamp.java106.pms;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//이 클래스가 스프링 IoC 관련해서 설정작업을 수행함을 지정
@Configuration

//자동으로 객체를 생성할 패키지 지정
//=> @Component가 붙은 클래스를 찾아 자동으로 객체를 생성한다.
//   또한 의존 객체를 자동 주입한다.
@ComponentScan(basePackages="bitcamp.java106.pms")
public class AppConfig {
    
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "bitcamp/java106/pms/sql/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}











