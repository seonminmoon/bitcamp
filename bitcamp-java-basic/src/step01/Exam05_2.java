// 정수의 리터럴2(literal) - 자릿수 표기

package step01;

public class Exam05_2 {
    public static void main(String[] args){
        // _를 사용하여 숫자의 자릿수를 표시할 수 있다.
        // 물론 위치는 작성자 마음

        System.out.println(12783406);
        System.out.println(1278_3406);
        System.out.println(12_783_406);


        // 2진수 - bin
        // - 0b 또는 0B 로 시작한다.

        System.out.println(0b1100100);
        System.out.println(0b110_0100);
        System.out.println(0b1_1_0_0_1_0_0);
       // System.out.println(0b_110_0100); 언더바가 0b 바로옆에 오는건 안됨!
    }
}
 
// 10진수
// - 일반적으로 값을 알려주고 싶을 때 사용한다.
// 8진수
// - 코드에서 잘 사용하지 않는다
// 2진수
// - 메모리상태를 알려주고 싶을 때 사용
// 16진수
// - 2진수로 표기하면 너무 길어지기 때문에 주로 16진수로 표기함
//
// 결론!
// - 코드를 작성할 때 주로 10진수로 표기한다.
// - 간혹 메모리 상태에 집중하라고 강조하고 싶을 때 16진수로 표기한다.
