// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : select
package step25.ex1;

import java.sql.DriverManager;

public class Exam03_3 {
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
        
        if (isReceived) {
            // 서버에서 한 개의 레코드 값을 가져온 후 컬럼 값을 꺼낼 때
            // select 문에 나열한 순서대로 번호를 지정하면 된다.
            // 단 번호는 0부터가 아니라, 1부터 지정한다.
            // 그런데 컬럼의 번호를 지정하여 값을 꺼내면, 
            // 소스 코드를 읽을 때 매우 불편하다.
            // 즉 해당 번호가 어떤 컬럼을 가리키는지 알려면 select문을 살펴봐야 하는 번거로움이 있다.
            // 그래서 실무에서는 가능한 번호 대신 컬럼의 이름을 사용한다.
            System.out.printf("%d,%s,%s,%s \n", 
                     rs.getInt("bno"),
                     rs.getString("titl"),
                     rs.getString("cont"),
                     rs.getDate("rdt")); /* java.sql.Date 객체 리턴 */
            
            // DBMS에 설정된 컬럼의 타입에 따라 getXxx()를 호출하면 된다.
            // int, number => getInt()
            // char, varchar, text => getString()
            // date, datetime => getDate()
            // float => getFloat()
            // 등
            // 물론 컬럼의 타입과 상관없이 getString()으로 값을 꺼낼 수 있다.
        } else {
            System.out.println("서버에서 한 개의 레코드를 가져오지 못했다!");
        }
        rs.close();
        stmt.close();
        con.close();
    }
}


