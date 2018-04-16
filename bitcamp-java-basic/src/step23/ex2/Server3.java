// 대기열 - 대기열 크기 조정
package step23.ex2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("서버 실행!");
        
        keyScan.nextLine(); // 브레이크 걸기! 여기서 멈췄다가 엔터치면 넘어간다.
        // new ServerSocket(포트번호, 대기열개수);
        // => 대기열 개수를 초과하여 클라이언트가 연결을 요청하면 연결을 거절한다.
        ServerSocket ss = new ServerSocket(8888, 2); 
        System.out.println("클라이언트 연결을 기다리는중..."); // 서버 소켓 생성

        
        keyScan.nextLine(); 
        Socket socket = ss.accept();
        System.out.println("대기중인 클라이언트 중 한 개의 클라이언트에 대해 연결 승인!");

        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("입출력 스트림 준비!");
        
        
        keyScan.nextLine(); 
        
        System.out.println("클라이언트 데이터 수신 중...");
        System.out.println(in.nextLine());
        System.out.println("클라이언트 데이터 수신 완료!");
        
        System.out.println("클라이언트에게 응답 보냄!");
        out.println("ok!");
        
        // 자원 해제
        socket.close();
        System.out.println("클라이언트와의 연결 해제!");
        
        ss.close();
        System.out.println("서버 종료!");
    }
}

// 포트번호
// => 0 ~ 1023 (well-known port) - 잘 알려진 포트
//    - 특정 프로그램이 관습적으로 사용하는 포트 번호
//    - 프로그램을 작성할 때 가능한 이 퐅트 번호를 사용하지 말아야 한다.
//    - 7(echo), 20(FTP 데이터 포트), 21(FTP 제어포트), 23(telnet 원격제어포트),
//    - 25(SMTP), 53(DNS), 80(HTTP), 110(POP3), 143(IMAP) 등
// => 1024 ~ 49151 (registered port) - 등록된 포트
//    - 일반적인 통신 프로그램을 작성할 때 이 범위 포트 번호를 사용한다.
//    - 다만 이 범위의 번호 중에서 특정 프로그램이 널리 사용하는 번호가 있다.
//      가능한 그 번호도 피하라!
//    - 8080(proxy), 1521(Oracle), 3306(MySQL) 등
// => 49152번 ~ 65535 (dynamic port) - 동적 포트
//    - 통신을 하는  프로그램에 반드시 포트번호를 가져야 한다.
//      그래야 OS가 해당 프로그램을 구분할 수 있다.
//    - 따라서 클라이언트 프로그램도 포트번호를 갖는데,
//      프로그램에서 결정하는 것이 아니라, OS로부터 자동발급 받는다.
//    - 이 범위의 포트번호는 클라이언트가 OS로부터 자동 발급 받는 포트번호이다.



