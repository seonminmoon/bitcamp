package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = 
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext()); 
        boardDao = iocContainer.getBean(BoardDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Board board = boardDao.selectOne(no);
            if (board == null) {
                throw new Exception("유효하지 않은 게시물 번호입니다.");
            }
            
            request.setAttribute("board", board); // request라는 저장소에 board라는 이름으로 저장!
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("/board/view.jsp").include(request, response);
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 상세조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

//ver 39 - forward 적용
//ver 37 - BoardViewController를 서블릿으로 변경
//         HTML로 출력 
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 view() 메서드를 추출하여 클래스로 정의.
