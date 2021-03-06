// 인터페이스 정의2 - 모든 메서드는 abstract
package step14.ex2;

public interface A2 {
    // 인터페이스에 선언하는 메서드는 호출 규칙을 정의한 것이다.
    // 규칙은 클래스가 따라야 한다.
    // 그래서 인터페이스에 선언되는 모든 메서드는 몸체를 구현하지 않는다.
    // void m1() {} ; //구현하면, 컴파일 오류!
    
    // 몸체를 구현하지 않아야 하기 때문에 추상 메서드(abstract)로 선언한다.
    // 추상 메서드임을 표시하기 위해 abstract 붙인다.
    abstract void m2();
    
    abstract void m3();
    
    // => 인터페이스의 모든 메서드는 기본적으로 몸체를 구현하지 않기 때문에
    //    abstract를 생략해도 된다.
    void m4();

}
