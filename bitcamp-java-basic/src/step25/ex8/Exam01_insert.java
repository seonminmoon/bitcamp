// mybatis + spring IoC - 트랜잭션 적용 전
package step25.ex8;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext(
                        "step25/ex8/application-context.xml");
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        
        Board board = new Board();
        
        board.setNo(141);
        board.setTitle("1111");
        board.setContent("xxxx");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(142);
        board.setTitle("2222");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(141);
        board.setTitle("3333");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        System.out.println("----------------------------------");
        
    }
}


