// 데이터를 처리하는 코드를 별도의 클래스로 캡슐화시킨다.
// => Data 영속성(지속성)을 관리하는 클래스를 DAO(Data Access Object)라 부른다.
// => data 영속성(지속성)
//    - 데이터를 저장하고 유지하는 것.
//    - "데이터 퍼시스턴스(persistence)"라 부른다.
package step25.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        PreparedStatement stmt = con.prepareStatement(
                "delete from ex_board where bno=?");) {
                    
        stmt.setInt(1, no);
        return stmt.executeUpdate();
        }
    }
    
    public List<Board> list() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 오토클로즈가 아니라서
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,rdt from ex_board");
            
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Board> arr = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setRegisteredDate(rs.getDate("rdt"));
                arr.add(board);
            }
            return arr;
        }
    }

    public int insert(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try ( // 현재 try()안에 있는 것들을 자동으로 close() 하기 위해서 try로 묶음!
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into ex_board(titl,cont,rdt) values(?,?,now())");) {
        
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            
            return stmt.executeUpdate();
        }
    }

    public int update(Board board) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                "update ex_board set titl=?, cont=?, rdt=now() where bno=?");) {
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
        
    }

    public Board view(String no) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // try() 안에 넣을 수 있는건 객체를 생성하는 변수만 넣을 수 있고 일반 코드는 넣을 수 없다.
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,cont,rdt from ex_board where bno=?");) {
            
            
            stmt.setString(1, no);
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
            
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setRegisteredDate(rs.getDate("rdt"));
                return board;
            }
        }
    }
}


