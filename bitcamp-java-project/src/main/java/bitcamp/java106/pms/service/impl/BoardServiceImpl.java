// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.service.BoardService;

// Component랑 똑같다. 스프링에서는 Service만 제어하고싶을 때 제어할 수 있도록 이름만 달리 해서 만들었음
@Service
public class BoardServiceImpl implements BoardService {
// 어떤 회사는 DefaultBoardService (BoardService의 기본구현체라는 의미) 라고도 한다.
    BoardDao boardDao;
    // @Autowired 보다는 생성자 만드는걸 추천! 의존객체로 만들자
    
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public List<Board> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return boardDao.selectList(params);
    }
    
    @Override
        public Board get(int no) {
            return boardDao.selectOne(no);
        }
    
    @Override
        public int add(Board board) {
            return boardDao.insert(board);
        }
    
    @Override
        public int update(Board board) {
            return boardDao.update(board);
        }
   
    @Override
        public int delete(int no) {
            return boardDao.delete(no);
        }
}
