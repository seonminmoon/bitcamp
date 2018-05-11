// 서블릿 만들기 3 - 추상 클래스를 상속 받아서 Servlet 인터페이스를 간접적으로 구현하기.
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => javax.servlet.Servlet 인터페이스를 직접 구현하는 것보다
//	    미리 구현한 클래스를 상속받아서
//	    필요한 메서드만 구현하거나 재정의하는 것이 편하다!
// => 그래서 이미 자바에서는 GenericServlet 이름을 가진 클래스를 제공하고 있다.
// => 있는데 왜 만든 겁니까?
//    - 내부적으로 어떻게 돌아가는지 확인하기 위해서

@WebServlet("/step01/exam03")
public class Exam03 extends javax.servlet.GenericServlet {
	
	
//	private static final long serialVersionUID = 1L;
//
//	// 시리얼라이저블 인터페이스를 구현한 클래스는 그 안에 있는 데이터를 바깥으로 내보낼지도 모르기때문에 serialVersionUID를 정의한다.
//	// => 서블릿이 바깥으로 내보낼 데이터가 있다는 것을 의미한다.
//	// => 
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트가 이 서블릿의 실행을 요청할 때마다 호출된다.
        // => 서블릿이 해야할 일을 처리하는 코드를 여기에 둔다.
        System.out.println("Exam03.service()");
    }
}