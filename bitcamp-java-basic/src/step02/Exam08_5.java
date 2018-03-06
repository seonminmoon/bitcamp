// 형변환 - 명시적 형변환
package step02;

public class Exam08_5 {
    public static void main(String[] args){

        float f = 3.14f;
        double d = 9876.56789;

        // 부동소수점 메모리 값을 정수 메모리에 저장 못하는데,
        // 값이 짤릴 수 있음을 알면서도
        // 정수<--부동소수점 값 저장하고싶을 때
        // 또는 작은메모리<--큰메모리 저장하고 싶을 때
        // 컴파일러에게 강제로 값을 넣을것을 명시하라!
        int i= (int)f;  // 소수점 이하 제거
        long l= (int)d;  // 소수점 이하 제거
        System.out.println(i);
        System.out.println(l);
    }
}

// 명시적 형변환
// - 큰 메모리값을 작은 메모리값으로 변환 할 때
// - 부동소수점을 정수로 변환할 때
// - 문법
//   변수 = (바꾸고자하는타입) 변수 또는 값;
