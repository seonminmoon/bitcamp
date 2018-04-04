// 인터페이스 구현 - 추상 클래스를 이용하여 인터페이스 구현을 도와줄 수 있다.
package step15.ex2;

// 인터페이스에 메서드가 많지만, 그 중에 특정 메서드만 구현하고 싶다!
// => 이런 상황을 도와주기 위해 중간에 추상 클래스를 적용할 수 있다.
public abstract class Exam03 implements Servlet {
// 추상 클래스에서 특정 메서드를 제외한 나머지 메서드를 구현할 수 있다.
    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }
}
