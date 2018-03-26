// 캡슐화(encapsulation) - 접근 범위 테스트
package step11.ex13;

import step11.ex13.sub.B;
import step11.ex13.sub.C; // import 단축키 - 컨트롤쉬프트+O

public class Exam02_1 extends C {
    public static void main(String[] args) {
        A obj1 = new A();
        
        // obj1.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용가능
        obj1.defaultVar = 100; // OK! 이 클래스는 A 클래스와 같은 패키지에 소속되어 있다.
        obj1.protectedVar = 100; // OK! 비록 이 클래스가 자식클래스는 아니지만 같은 패키지에 소속되어 있다.
                                 // protected 는 자식클래스,같은패키지클래스 까지 사용가능
        obj1.publicVar = 100; // OK! 모두다 접근 가능
        
        B obj2 = new B();
        
        // obj2.privateVar = 100; // 오류! 오직 그 클래스 안에서만 사용 가능.
        // obj2.defaultVar = 100; // 오류! 같은 패키지까지만 접근 가능.
        // obj2.protectedVar = 100; // 오류! 같은 패키지 또는 자식클래스 접근 가능.
        obj2.publicVar = 100; // OK! 모두다 접근 가능

        C obj3 = new C();
        
        // obj2.privateVar = 100; // 오류! 오직 그 클래스 안에서만 사용 가능.
        // obj2.defaultVar = 100; // 오류! 같은 패키지까지만 접근 가능.
        // obj3.protectedVar = 100; // 오류! 같은 패키지 또는 자식클래스 접근 가능.
                                  // 자식 클래스인데 접근 불가?
                                  // 이유 => 자기의 인스턴스 변수가 아니다.
         obj3.publicVar = 100; // OK! 모두다 접근 가능
         
         Exam02_1 obj4 = new Exam02_1();
         // obj4.privateVar = 100; // 접근 불가! C 클래스에서만 접근 가능
         // obj4.defaultVar = 100; // 접근 불가! C 클래스와 같은 패키지가 아니다.
         obj4.protectedVar = 100; // OK! C의 Exam02_1 는 C의 자식클래스이며,
                                  // 또는 C 로부터 상속받아서 만든 자기 변수이다.
         obj4.publicVar = 100; // OK! 모두다 접근 가능
    }
}

// private      : 클래스 안에서만 접근 가능
// (default)    : private + 같은 패키지 소속
// protected    : (default) + 자식 클래스에서 자신이 만든 변수일 경우
// public       : 모두 다 가능
//
// 실무
// => 인스턴스 변수는 보통 private 으로 접근을 제한한다.
// => 겟터,셋터는 public 으로 접근을 모두에게 공개한다.
// => 일반 메서드도 public 으로 접근을 모두에게 공개한다.
// => 그 클래스 내부에서만 사용되는 메서드는 private으로 접근을 제한한다.
// => 자식 클래스의 접근을 허용할 필요가 있을 경우에만 protected로 만든다.
// => 다른 개발자가 사용할 클래스 모음을 만들 때
//    그 모음집 내에서만 사용될 변수나 메서드인 경우 (default)로 접근을 제한한다.
