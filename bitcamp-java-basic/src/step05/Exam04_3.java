// 흐름 제어문 - for 반복문과 배열
package step05;
import java.util.Scanner;

public class Exam04_3 {
    public static void main(String[] args) {

        
       /* String[] names = new String[5];
            names[0] = "홍길동";
            names[1] = "홍길동";
            names[2] = "홍길동";
            names[3] = "홍길동";
            names[4] = "홍길동";
        */
        String[] names = {"홍길동","임길동","문길동","장길동","민길동"};

        for (int i = 0; i < names.length; i++) 
            System.out.println(names[i]);

        System.out.println("-----------------------");

        // 배열의 처음부터 끝까지 값을 꺼내는 것이라면
        // 다음의 for 문법을 사용하라! 아주 편하다!
        // for (값을 저장할 변수 선언 : 배열주소) 문장;

        for (String name : names)
            System.out.println(name);

        // 위의 방식으로 for 문을 사용할 경우
        // 변수 선언을 바깥에 둘 수 없다.
        /*
        String name2;
        for (name2 : names) // 컴파일 오류!
            System.out.println(name2);
            */
        }
    }