// 초기화 블록 - 인스턴스 블록 초기화 순서

// 일반적으로 쓰는 소스코드는 아니지만 알아둬야 하는 문법! 그냥 참고하셈!
package step08;

public class Exam06_3 {
    
    static class A {
        
        A() {
            // 3) 생성자 실행
            a = 300;
        }
        
        {
            // 2) 인스턴스 블록 실행
            a = 200; 
        }
        
        // 1) 인스턴스 변수 생성 및 할당 연산자 실행(초기화 문장 실행)
        //    0 으로 초기화 -> 100으로 초기화
        int a = 100;
    }
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.println(obj1.a);
    }
}
