// 게시물 관리 - 조회 + PreparedStatement
package step25.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam01_view {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in); 
        System.out.print("조회할 게시물 번호? ");
        String no = keyScan.nextLine(); // SQL문 뒤에 붙일것이기 때문에 String 이어도 상관 없다.
        
        try {
            BoardDao boardDao = new BoardDao();
            Board board = boardDao.view(no);
            if (board == null) {
                System.out.println("해당 번호의 게시물이 없습니다.");
            } else {
                System.out.printf("번호: %d \n", board.getNo());
                System.out.printf("제목: %s \n", board.getTitle());
                System.out.printf("내용: %s \n", board.getContent());
                System.out.printf("등록일: %s \n", board.getRegisteredDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        keyScan.close();
    }
}


