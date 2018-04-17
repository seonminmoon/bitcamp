// Stateless와 Stateful 의 비교 - 멀티스레드 적용(stateful의 문제점 해결) 
package step23.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateful 방식의 특징
// => 클라이언트와 계속 연결을 유지하기 때문에 작업 결과를 계속 서버에 유지할 수 있다.
// 
public class StatefulServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        // 합계를 계산하는 서버를 만들어보자!
        ServerSocket ss = new ServerSocket(8888);
        
        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중...");
            //processRequest(socket);
            
            // 클라이언트의 요청을 처리할 담당자를 준비한다.
            MyThread requestHandler = new MyThread(socket);
            
            // 그 담당자에게 작업을 실행시킨다.
            requestHandler.start();
        }
    }
    
    // 클라이언트의 요청 처리를 담당할 객체이다.
    // => 스레드로서 독립적으로 수행한다.
    static class MyThread extends Thread {
        Socket socket;
        
        public MyThread(Socket socket) {
            this.socket = socket;
        }
        
        // 외부에서 start()를 호출하면 내부에서 run()을 실행한다.
        @Override
        public void run() {
            try (
                Socket socket2 = socket;
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                ) {
                    
                    // 클라이언트와의 연결을 끊을 때까지 계속 계산 결과를 서버에 유지한다.
                    // => 그래서 "connectionful(stateful)" 방식이라 부른다.
                    int sum = 0;
                    
                    while (true) {
                        String str = in.nextLine();
                        if (str.equals(""))
                            break;
                        sum += Integer.parseInt(str);
                   }
                    
                out.println("결과 = " + sum);
                
                } catch (Exception e) {
                    System.out.println("클라이언트 요청 처리 주 오류 발생!");
                }
            }
        }
    
    
    
    static void processRequest(Socket socket) throws Exception {
        
        // "stateful"은 한 번 연결되면 연결을 끊을 때까지 데이터를 주고 받는다.
        // 그래서 각 클라이언트의 작업 결과를 유지할 수 있다.
        // 단, 현재 버전의 문제는 클라이언트가 연결을 끊을 때까지
        // 다른 클라이언트의 요청을 처리하지 못한다는 문제가 있다.
        // 해결책?
        // 멀티스레드 이용
    }
}






