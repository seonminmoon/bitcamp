// 인터페이스 구현
package step15.ex2;

public abstract class Exam02 implements Servlet {

    // 인터페이스에 선언된 메서드를 한 개라도 빠뜨리면
    // 추상 메서드인채로 남아 있기 때문에
    // 일반 클래스가 될 수 없고,
    // 추상 클래스가 되어야한다.
    
    public void init() {
        
    }

    public void destroy() {
        
    }

    public String getServletInfo() {
        return null;
    }

    public String getServletConfig() {
        return null;
    }

}
