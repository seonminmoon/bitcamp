// 리터럴(literal)

package step01;

public class Exam04 {
    public static void main(String[] args){
        //정수
        // => 4byte 크기의 정수
        System.out.println(10);
        System.out.println(+10);
        System.out.println(-10);

        // => 8byte 크기의 정수
        //    숫자 뒤에 l, L을 붙인다.
        System.out.println(10L);
        System.out.println(+10l);
        System.out.println(-10L);
        
        //부동소수점 - 소수점이 움직인다
        // => 4byte 크기
        //    숫자 뒤에 F, f를 붙인다.
        System.out.println(3.14F);
        System.out.println(3.14f);
        
        // => 8byte 크기
        System.out.println(3.14);
        System.out.println(31.4e-1); //3.14랑 같은 값 e(익스포넨셜)10-1승 곱하라
    
        //문자열
        System.out.println("장아찌..");
        
        //한 개의 문자
        System.out.println('a');

        //논리값
        System.out.println(true);
        System.out.println(false);
    }
}

// 자바 코드로 값을 표현(literal)한 것

