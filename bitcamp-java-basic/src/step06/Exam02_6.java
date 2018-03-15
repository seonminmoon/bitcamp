// 메서드 : 가변 파라미터 vs 배열 파라미터
package step06;

import java.util.Scanner;

public class Exam02_6 {

    // 가변 파라미터
    static void hello(String... names) { 
        for (int i=0; i<names.length; i++) {
            System.out.printf("%s님 반갑습니다.",names[i]);
        }
    }

    // 가변 파라미터
    static void hello2(String... names) { 
        for (int i=0; i<names.length; i++) {
            System.out.printf("%s님 반갑습니다.",names[i]);
        }
    }
    
    public static void main(String[] args) {
        // 가변 파라미터의 메서드를 호출할 때는
        // => 다음과 같이 낱개의 값을 여러 개 줄 수 있고,
        hello("홍길동", "임꺽정", "유관순");
        hello(arr);
        System.out.println("=========================");

        // 배열 파라미터의 메서드를 호출할 때는
        // => 가변 파라미터와 달리 낱개의 값을 열개 줄 수 없다.

        hello2("ㅁ","ㅅ","ㅁ");
        hellow(arr2)
        System.out.println("=========================");
    }  


}