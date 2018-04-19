package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/add")
public class BoardAddController implements Controller {
    BoardDao boardDao;
    
    public BoardAddController(BoardDao boardDao) {
        this.boardDao = boardDao;
    } 
     
    public void service(ServerRequest request, ServerResponse response) {
        // 이 컨트롤러는 오직 게시물 입력에 대해서만 작업을 수행한다.
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));
        
        /* (멀티)스레드 테스트용 코드
        for (int i = 0; i < 300000000; i++) {
            //Math.random(); // 0 <= x(double) < 1  // 완전한 랜덤이아님.같은 값을 가질 수 있기 때문
            // 현재(2018) '양자'를 활용한 랜덤값 추출을 개발함
            // 랜덤함수쓰면 멀티스레드 작동안됨!
            // for문을 하나의 atomic(원자단위)으로 취급되기 때문에 하나의 작업이 끝날때까지 다른 작업 진행안함
            Math.asin(34.8);
        }
        */
        
        boardDao.insert(board);
        
        
        PrintWriter out = response.getWriter();
        out.println("등록 성공!");
    }

}

//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
