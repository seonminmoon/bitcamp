// 초기화 블록 - 클래스 블록의 목적

// 일반적으로 쓰는 소스코드는 아니지만 알아둬야 하는 문법! 그냥 참고하셈!
package step08;

public class Exam06_5 {
    public static class A {
        static float pi;
        static float area(int r) {
            return 2 * pi * r;
        }
        // 스태틱 블록은 클래스 멤버를 사용하기 전에 유효한 값을 초기화시키는 것이 목적이다.
        static {
            pi = 3.14159f;
        }
    }
        
    public static void main(String[] args) throws Exception {
        System.out.println(A.area(25));
    }
}
