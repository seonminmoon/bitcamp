package step08;
import java.util.Scanner;
//클래스 메서드 응용

public class Exam02_2 {
    static class Math {
        // 다음 메서드와 같이 인스턴스 변수를 사용하지 않고
        // 파라미터 값을 가지고 작업하는 경우에 보통 클래스 메서드로 정의한다.
        
        public static int abs(int value) { // 절대값을 리턴하는 함수
            if (value < 0)
                return value * -1;
            return value;
        }
    }
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("숫자를 입력하세요> ");
        int value = keyScan.nextInt();
        
        // 이렇게 특정 인스턴스의 값을 다루는 것이 아니라
        // 외부에서 전달한 파라미터값을 가지고 작업 수행하는 메서드인 경우
        // 클래스 메서드로 정의하면 사용하기 편하다!!
        int result = Math.abs(value);
        System.out.printf("절대값: %d \n", result);
    }

}

// 결론!
// 클래스 메서드(스태틱 메서드)
// => 인스턴스 변수를 사용하지 않을 경우 클래스 메서드로 선언하라!
// 인스턴스 메서드
// => 인스턴스 변수를 사용할 경ㅇ우 인스턴스 메서드로 선언하라.
//
// 실무!
// => 일단 인스턴스 메서드로 무조건 만들라!
// => 인스턴스 변수를 완전히 사용하지 않음을 확신하면 
//    그때 클래스 메서드로 전환하라.