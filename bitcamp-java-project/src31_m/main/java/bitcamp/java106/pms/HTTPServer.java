// HTTP 프로토콜에 따라 요청을 처리할 서버
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer (int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    
    public void execute() throws Exception {
        // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버 실행 했음!");
        
        while (true) {
            // 대기열에서 기다리고 있는 HTTP 클라이언트 중에서 먼저 연결된 클라이언트를 꺼낸다. 
            Socket socket = serverSocket.accept();
            
            // 클라이언트 요청을 처리할 코드를 기존의 실행 흐름에서 분리하여 실행한다.
            // 그리고 바로 새 스레드(실행흐름)의 실행을 시작시킨다.
            System.out.println("클라이언트 요청 처리중...");
            new RequestProcessorThread(socket).start(); // 스레드의 run명령을 실행한다
            
            // 그리고 기존의 실행은 위의 t 스레드와 상관없이 계속 진행한다.
            
        }
    }
    
    // 기존의 실행 흐름과 분리하여 명령을 처리할 클래스
    class RequestProcessorThread extends Thread {
        Socket socket;
        
        public RequestProcessorThread(Socket socket) {
            this.socket = socket;
        }
        
        // 기존의 실행 흐름에서 분기되어 독립적으로 실행할 코드를 이 메서드에 두어라!
        @Override
        public void run() {
            
            PrintWriter out = null;
            Scanner in = null;
            
            try {
                // 입출력 스트림을 가져온다.
                out = new PrintWriter(socket.getOutputStream());
                in = new Scanner(socket.getInputStream()); 
                
                // HTTP 프로토콜에서 요청 정보를 읽는다.
                boolean firstLine = true;
                String requestURI = null;
                
                while (true) {
                    String line = in.nextLine();
                    if (line.equals(""))
                        break;
                    
                    if (!firstLine)
                        continue;
                    
                    // HTTP 요청 프로토콜에서 첫 번째 줄에 있는 요청 URI 정보를 추출한다.
                    requestURI = line.split(" ")[1];
                    firstLine = false;
                }
                // ApplicationContainer에게 실행을 위임한다.
                String result = applicationContainer.execute(requestURI);
                
                // result를 가지고 HTTP 프로토콜에 따라 응답한다.
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain;charset=UTF-8");
                out.println();
                out.println(result); // 빈 줄 다음에 받은데이터를 화면에 뿌린다.
                
            } catch (Exception e) {
                out.println("HTTP/1.1 500 Internal Serber Error");
                out.println("Content-Type: text/plain;charset=UTF-8");
                out.println();
                out.println("서버 오류!");
                e.printStackTrace(out);
                out.println();
            } finally {
                out.close();
                in.close();
                try {socket.close();} catch (Exception e) {}
            }
        }
    }
    
    private void processRequest(Socket socket) {}
}
