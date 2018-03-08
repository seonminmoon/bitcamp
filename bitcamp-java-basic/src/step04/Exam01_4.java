// 산술 연산자 : 암시적 형변환

package step04;

public class Exam01_4 {
    public static void main(String[] args){
        int i = 5;
        int j = 2;
        float r = (float)i / j;
        System.out.println(r);    // 결과값 2.0
                                  // 결과값 2.5 가 나오도록 수정하기
        // 정수끼리 나누면 실수값 날라가고 정수 값만 나오는데
        // float 은 실수 값이라서 2.0 으로 출력됨.
        // 애초에 i/j 를 float 으로 나눠버리면 실수값이 날라가지 않음.
        // 따라서 float r 값이 2.5 라고 나오게됨.
    }
}
