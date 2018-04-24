// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : select
package step25.ex1;

import java.sql.DriverManager;

public class Exam03_4 {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        System.out.println("DBMS와 연결됨!");
        
        
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,cont,rdt from ex_board"); // bno 부터 1번,2번,3번,4번 이다. 0번부터 아님!
        boolean isReceived = rs.next(); // 가져왔으면 true, 가져올게 없다면 false
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s,%s \n", 
                     rs.getInt("bno"),
                     rs.getString("titl"),
                     rs.getString("cont"),
                     rs.getDate("rdt")); /* java.sql.Date 객체 리턴 */
            
        } 
        rs.close();
        stmt.close();
        con.close();
    }
}


