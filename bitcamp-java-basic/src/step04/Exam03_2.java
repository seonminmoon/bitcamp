// 논리 연산자 : &&, ||, !(not)

package step04;

public class Exam03_2 {
    public static void main(String[] args){

        // AND 연산자
        // - 두 개의논리 값이 모두 True 일 때 결과가 true가 된다.

        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false&& true);
        System.out.println(false&& false);

        System.out.println("=====================");
        // OR 연산자
        // - 두 개의 논리 값 중 한 개라도 true 이면 결과는 true 가 된다.
        System.out.println(true | true);
        System.out.println(true | false);
        System.out.println(false | true);
        System.out.println(false | false);

    }
}
