// 쿠키 : 클라이언트 쪽에 데이터를 보관하는 방법
package step10.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex1/exam02")
public class Exam02 extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        // 쿠키(cookie) 받기
        // => 쿠키는 서버가 요청하지 않아도 웹브라우저에게 무조건 보낸다.
        // => 물론 웹서버가 웹브라우저에 쿠키를 보낼 때 조건에 따라 웹서버에 보낸다.

        // 1) 쿠키 가져오기
        // => 안타깝게도 특정 이름을 가진 쿠키 값만 꺼내는 메서드가 없다.
        // 단점--> getParameter처럼 콕 찝어서 빼내는 메서드가 없다. => 그래서 배열 써야됨
        // 다행인건 Spring NVC 를 사용하면 걔가 대신 다 해주기때문에 NVC를 사용해야함
        Cookie[] cookies = request.getCookies(); 
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("클라이언트가 보낸 쿠키들:");
        
        for (Cookie cookie : cookies) {
            out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
        }
        
// 웹브라우저가 웹서버로 쿠키를 보내는 HTTP 프로토콜?
//        GET /bitcamp-web01/step10/ex1/exam02 HTTP/1.1
//        Host: localhost:8888
//        Connection: keep-alive
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//        Accept-Encoding: gzip, deflate, br
//        Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//        Cookie: c1=aaa; c2=123
    }
}
