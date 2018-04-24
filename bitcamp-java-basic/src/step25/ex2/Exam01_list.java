// 게시물 관리 - 목록
package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam01_list {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
                "select bno,titl,rdt from ex_board");
        boolean isReceived = rs.next();
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s \n", 
                     rs.getInt("bno"),
                     rs.getString("titl"),
                     rs.getDate("rdt")); /* java.sql.Date 객체 리턴 */
            
        } 
        rs.close();
        stmt.close();
        con.close();
    }
}


