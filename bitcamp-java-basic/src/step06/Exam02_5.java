// 메서드 : 개념 및 기본 문법 V
package step06;

import java.util.Scanner;

public class Exam02_5 {

    // 5) 메서드 : 리턴값(o), 파라미터(o)
    // [리턴타입] 메서드명(타입...변수) {...}
    // => 0개 이상의 값을 받을 때 선언하는 방식
    // => 내부적으로 배열처럼 사용한다.
    static void hello(String... names) { 
        for (int i=0; i<names.length; i++) {
            System.out.printf("%s님 반갑습니다.",names[i]);
        }
    }
    
    public static void main(String[] args) {
        hello(); // names 배열 개수 - 0
        System.out.println("============");
        
        hello("홍길동");
        System.out.println("============");
        hello(); // names 배열 개수 - 1
        System.out.println("============");
        
        hello("홍길동", "임꺽정", "유관순");

        System.out.println("============");

        String[] arr = ("김구","안중근","윤봉길","유관순");
        hello(arr);        
        System.out.println("============");
        // hello("홍길동", 20, "유관순"); // 다른 타입은 안됨, 컴파일 오류!
    }
}