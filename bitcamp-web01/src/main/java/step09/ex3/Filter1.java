package step09.ex3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/step09/ex3/*")
public class Filter1 implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc = request.getServletContext(); // => Spring 에서 이용한다(프로젝트src40 참고)
		System.out.printf("step09.ex3.Filter1 ==> %s, %s\n",
				sc.getInitParameter("p1"), sc.getInitParameter("p2"));
		
		// 다음 필터나 서블릿을 실행한다.
		chain.doFilter(request, response);
		
		// 필터는 콘솔창에 출력되게 했기 때문에 콘솔창에서 확인하라!
	}

}
