// 변수 - 변수 선언과 값 저장
package step02;

public class Exam03_4 {
    public static void main(String[] args){
        // 변수 선언한 후 값 저장
        // - 모든 메모리를 준비한 후 값 저장
        int a1, a2;
        a1 = 100;
        a2 = 200;
        System.out.println(a1);
        System.out.println(a2);

        // 변수 선언과 동시에 값 저장
        // - 메모리를 준비한 후 즉시 값으로 초기화시키기
        int b1 = 100, b2 = 200;
        System.out.println(b1);
        System.out.println(b2);

        // 물론 여러 개의 변수 나열 시, 모든 값 초기화 시킬 필요는 없음
        // 메모리를 준비한 후 단 한 번이라도 값을 넣은 후에 사용해야 한다.
        // 만약 c2나 c4처럼 메모리를 어떤 값으로 초기화시키지 않은 상태에서
        // 출력하거나 사용하려하면 컴파일 오류 발생한다.
        int c1 = 100, c2, c3 = 200, c4;
        System.out.println(c1);
        // System.out.println(c2); // 오류!
        System.out.println(c3);
        // System.out.println(c4); // 오류!


    }
}
