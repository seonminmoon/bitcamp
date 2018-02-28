//main()
package step01;

public class Exam02 {
    public static void main(String[] args){ 
        // args 는 함수 f(n) 에서 n 에 해당하고
        // n 은 인자 라고 부르기 때문에 인자(argument) 줄여서 args
        // args 는 변수고 나머지는 바꾸면 안됨

        System.out.println("src/step01/Exam02");
    }
}

/*
 * 명령창에서 JVM이 바로 실행할수 있는 클래스는 main() 클래스이다.
 * 
 * => JVM이 클래스 실행하는 과정
 *    1) 실행할 클래스 파일을 CLASSPATH에 등록된 폴더에서 찾음
 *    2) 유효한 bytecode인지 검사
 *    3) public static void main(String[] args) {} 블록 찾음
 *    4) main() 코드 실행
 */