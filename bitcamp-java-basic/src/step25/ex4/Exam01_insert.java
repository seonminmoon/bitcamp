// 게시판 관리 - 등록 + PreparedStatement
package step25.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        // 사용자로부터 제목, 내용을 입력받는다.
        Board board = new Board();
        
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        
        try {
            DataSource dataSource = new DefaultDataSource();
            BoardDao boardDao = new BoardDao(dataSource);
            int count = boardDao.insert(board);
            System.out.printf("%d 개 입력 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}


