// 애플리케이션 컨테이너가 갖춰야 할 기능(규칙)을 정의한다.
package bitcamp.java106.pms;

public interface ApplicationContainer {
    String execute(String requestURI); // 서브클래스들은 execute() 오버라이딩 해서 규칙을 지켜야 한다.
}
