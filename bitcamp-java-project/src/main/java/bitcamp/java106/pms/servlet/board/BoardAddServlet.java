package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
	
	BoardDao boardDao;
	
	@Override
	public void init() throws ServletException {
		boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
	}
    
    //add, update같은 경우는 post 요청으로 데이터가 넘어온다.
    @Override
    protected void doPost(
    		HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	
    	// 클라이언트가 보낸 데이터가 어떤 문자표를 사용해서 작성한지 알아야만
    	// String 객체(UTF-16)로 값을 꺼낼 수 있다.
    	request.setCharacterEncoding("UTF-8");
    	
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            boardDao.insert(board);
            out.println("등록 성공!");
        } catch (Exception e) {
            out.println("등록 실패!");
            e.printStackTrace(out);
        }
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
