// 예외 던지기 - 예외 상황을 호출자에게 알려주기 : RuntimeException 을 던질 경우
package step21.ex3;

public class Exam02_2 {
    
    // RuntimeException은 클래스 이름을 보더라도 Exception 의 서브클래스이다.
    // 마찬가지로 시스템 에러 서브클래스 이름도 ~Error 로 끝난다
    static void m() throws Throwable {
        throw new RuntimeException(); // ok!
    }
    
    // Exception의 서브 클래스임에도 불구하고
    // RuntimeException 클래스인 경우 메서드 선언부에 예외를 던진다고 선언하지 않아도 된다.
    // 왜? 스텔스 모드(비유!) 를 지원하기 위해 만든 예외이다.
    static void m2() {
        throw new RuntimeException();
    }
    
    
    public static void main(String[] args) {
    }

}
