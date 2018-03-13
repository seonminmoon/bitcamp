// 흐름 제어문 - for 반복문
package step05;
import java.util.Scanner;

public class Exam04_2 {
    public static void main(String[] args) {
        // for (변수선언 및 초기화; 조건; 증감문) 문장;
        // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

        // for 문 안에 선언된 변수는 for 문을 나가는 순간 제거된다.
        for (int i = 1; i <= 5; i++) 
            System.out.println(i);

        System.out.println("-----------------------");

        // 그래서 다음과 같이 i 변수의 값을 조회하려 하면
        // 컴파일 오류가 발생한다.

          //  System.out.println(i); // 컴파일 오류~

        // 반복문을 종료한 뒤라도 해당 변수의 값을 사용하고 싶으면,
        // 다음과 같이 반복문 밖에 변수를 선언하라.

        int x = 0;
        for (x = 1; x <= 5; x++) 
            System.out.println(x);
        System.out.printf("x = %d\n", x);
        }
    }