package step11.ex06;
public class B extends A {
    int v2; 

    B() {
        // 수퍼 클래스의 어떤 생성자를 호출할지 지정하지 않으면 컴파일러는
        // 다음과 같이 수퍼 클래스의 기본 생성자를 호출하라는 명령을 붙인다.
        // super();
        System.out.println("B() 생성자!");
    }
}

