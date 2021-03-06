// 부동 소수점의 리터럴

package step01;

public class Exam07_1 {
    public static void main(String[] args){

        // 소스 코드에 10진수가 아닌 16진수가 있다면,
        // 그것은 개발자가 의도적으로 값이 아닌 2진수를 강조하기 위함이다.
        System.out.println(0x41); // 출력할 때는 10진수가 출력된다.
        
        // 해당 숫자가 단순한 정수값이 아니라,
        // 문자 코드 값임을 알려주면,
        // println() 명령어는 그 문자 코드에 해당하는 문자를
        // 폰트 파일에서 찾아 출력한다.
        System.out.println((char)0x41); 
        // => 이렇게 문자의 코드 값을 알고 있으면 문자를 출력할 수 있다.

        // 만약 문자의 코드 값을 모를 때는?
        // => 특별한 기호('')를 사용하여 문자를 표기하라!
        System.out.println('A');

        // 특수 문자를 입력할 수 없는 경우에는
        // 다음과 같이 그 특수 문자의 유니코드 값을 ''에 넣어도 된다.
        // 단, 코드값 앞에 \ u 문자를 붙여야 한다.
        System.out.println('\u2602'); //구글에 유니코드 테이블 검색
        // 결과: ?
        // 텍스트파일에 없어서 println() 이 못찾음
        System.out.println('\u3144'); 
        System.out.println('\u3182'); 
        System.out.println((char)0x3182); 
    }
} 