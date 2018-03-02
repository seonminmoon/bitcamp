// 부동 소수점의 리터럴 - 크기

package step01;

public class Exam06_2 {
    public static void main(String[] args){

        // 부동소수점도 크기에 따라 작성하는 방법이 다르다.
        System.out.println(3.14); // 8바이트 크기의 부동소수점

        // 부동소수점 뒤에 F,f를 붙이면 4byte 크기의 부동소수점으로 다룬다.
        // - 주로 소문자를 붙인다.
        System.out.println(3.14f); // 4바이트 크기의 부동소수점

        // 궁금?
        // - 정수는 메모리의 크기에 따라 최소값과 최대값이 정해진다.
        // - 부동소수점의 최소/최대값은?
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

        //4byte 부동소수점 테스트
        System.out.println("===================");
        System.out.println(987.6543f);
        System.out.println(987654.3f);
        System.out.println(9.876543f);

        // 다음 값은 4바이트 메모리 범위를 넘어가는 부동소수점이기 때문에
        // 값이 짤린다.
        System.out.println(987654.345678f);
        System.out.println(98765434567.8f);
        System.out.println(9.87654345678f);

        //8byte 부동소수점 테스트
        System.out.println("===================");
        System.out.println(987.6543);
        System.out.println(987654.3);
        System.out.println(9.876543);

        // 다음 값은 8바이트 메모리 범위 안에서 표현 가능한 부동소수점이기 때문에
        // 정상적으로 출력된다. 
        System.out.println(987654.345678);
        System.out.println(98765434567.8);
        System.out.println(9.87654345678);
        
        System.out.println("===================");
        System.out.println(7 * 0.1);
        // 결과: 0.7000000000000001
        // 이유:
        //  - IEEE-754 규격에 따라 부동소수점을 2진수로 바꾸다보면
        //    정확하게 2진수로 딱 떨어지지 않는 경우가 있다.
        //    CPU, OS, 컴파일러, JVM의 문제가 아니다.
        //  - IEEE-754의 방법에 내재되어 있는 문제다.
        // 해결책?
        // - 시스템에서 필요한 만큼 소수점 이하 자리수를 적절히 잘라 사용하라!

    }
}

// Test11_9 참고

// 결론!
// - 32비트(Float) 메모리에 부동소수점을 저장할 때는
//   유효자릿수 7자리까지 (거의) 가능하다.
// - 64비트(double) 메모리에 부동소수점을 저장할 때는
//   유효자릿수 15자리까지 (거의) 가능하다.
// - 그래서 32비트 float을 단정도(single-precision)라 부르고,
//   64비트는 두 배 정밀하게 값을 저장한다고 해서 배정도(double-precision)이라 부른다