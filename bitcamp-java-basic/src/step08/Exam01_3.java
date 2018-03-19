// 클래스 변수
package step08;

public class Exam01_3 {
    // 지금 당장 A 클래스 앞에 붙은 static은 고민하지 말라!
    // 이 예제의 목표는 static 변수이다.
    static class A {
        // 클래스 변수 = static 변수
        // => 클래스를 로딩하는 순간 자동 생성된다.
        // => 클래스와 함께 "Method Area" 영역에 존재한다.
        static int v1;
        static boolean v2;
        
    }
    public static void main(String[] args) {
        
        // 클래스 변수 사용법
        // 클래스명. 스태틱 변수명 = 값;
        // 클래스를 사용하는 순간 클래스가 로딩되고, 스태틱 변수는 자동생성된다.
        A.v1 = 100;
        A.v2 = true;
        
        System.out.printf("%d, %b \n", A.v1, A.v2);
    }

}
