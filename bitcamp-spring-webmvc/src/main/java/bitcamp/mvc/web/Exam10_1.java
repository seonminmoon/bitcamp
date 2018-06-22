// 인터셉터 - 페이지 컨트롤러를 실행하기 전후에 개입하기. 필터와 같은 역할을 한다.
package bitcamp.mvc.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam10_1")
public class Exam10_1 {
    BoardDao boardDao;
    
    public Exam10_1(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping("list")
    public String list(Model model) {
        List<Board> boards = boardDao.selectList();
        model.addAttribute("boards",boards);

        // JSP로 보내서 DAO가
        return "exam10_1";
    }
}
