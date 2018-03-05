// 키보드 입력 받기
package step02;

public class Exam02_1 {
    public static void main(String[] args){
        // 키보드 정보를 가져온다.
        java.io.InputStream keyboard = System.in;

        // 키보드에서 값을 꺼내주는 도구를 연결한다.
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        // print()는 문자열을 출력한 후 줄바꿈 안함.
        System.out.print("팀 명 ?"); 
        
        //nextLine()
        //-Scanner 도구를 사용하여 키보드로부터 한줄의 문자열을 가져오는 명령어

        // Scanner 도구를 사용하여 키보드로부터 입력된 데이터를 읽어서
        // 한 줄의 문자열을 가져온다.
        // 사용자가 한줄 입력할 때까지,
        // 즉 입력 데이터에 줄바꿈을 의미하는 0d0a 2바이트(enter)가 들어올 때까지 대기
        // 사용자가 엔터키를 누르면, 
        // 입력값으로 0d0a 2바이트 값이 들어오고,
        // nextLine() 비로소 사용자가 입력한 값을 리턴한다.

        // 그리고 곧바로 println() 명령을 사용하여 콘솔로 출력한다.
        System.out.println(keyScan.nextLine());
    }
}

// System.out
// - 표준 출력 장치.
// - 즉 콘솔을(모니터, 명령창) 가리킨다. [출력]
// System.in
// - 표준 입력 장치
// - 즉 키보드를 가리킨다. [입력]