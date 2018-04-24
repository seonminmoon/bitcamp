// 게시물 관리 - 조회
package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam01_view {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in); 
        System.out.print("조회할 게시물 번호? ");
        String no = keyScan.nextLine(); // SQL문 뒤에 붙일거기 때문에 String 이어도 상관 없다
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
                "select bno,titl,cont,rdt from ex_board where bno=" + no);
        
        if (rs.next()) {
            System.out.printf("번호: %d \n", rs.getInt("bno"));
            System.out.printf("제목: %s \n", rs.getString("titl"));
            System.out.printf("내용: %s \n", rs.getString("cont"));
            System.out.printf("등록일: %s \n", rs.getDate("rdt"));
        } else {
            System.out.println("해당 번호의 게시물이 없습니다.");
        }
        
        
        rs.close();
        stmt.close();
        con.close();
        keyScan.close();
    }
}


