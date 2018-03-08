// 논리 연산자 : && or &

package step04;

public class Exam03_3 {
    public static void main(String[] args){
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true); // b까지 안가고 a 가 false 이면 a값 넣음
        // && 두개짜리는 효율연산이다
        System.out.printf("a=%b, b=%b, r=%b \n", a, b, r);

        a = false;
        b = false;
        r = a & (b = true); // 뒤에까지 감
        System.out.printf("a=%b, b=%b, r=%b \n", a, b, r);

        
    }
}
// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤에 명령은 실행하지 않는다.
//
// &, |
// - 앞의 피연산자의 값으로 결과를 알 수 있을지라도
//   뒤에 놓인 명령까지 모두 실행한다.
