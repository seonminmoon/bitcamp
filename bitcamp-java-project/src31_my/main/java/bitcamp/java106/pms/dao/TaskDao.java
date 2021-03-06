package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TaskDao {
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                    "delete from pms_task where tano=?");) {
                        
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
    }
    
    public List<Task> selectList(String teamName) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 오토클로즈가 아니라서
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select tano,titl,sdt,edt,stat from pms_task where tnm=?");
                
            ) {
            stmt.setString(1, teamName);
            
            try (ResultSet rs = stmt.executeQuery()) {
                ArrayList<Task> arr = new ArrayList<>();
                while (rs.next()) {
                    Task task = new Task();
                    task.setNo(rs.getInt("tano"));
                    task.setTitle(rs.getString("titl"));
                    task.setStartDate(rs.getDate("sdt"));
                    task.setEndDate(rs.getDate("edt"));
                    task.setState(rs.getInt("stat"));
//                    task.setWorker(new Member().getId(rs.getString("mid")));
                    arr.add(task);
                }
                return arr;
            }
        }
    }

    public int insert(Task task) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try ( // 현재 try()안에 있는 것들을 자동으로 close() 하기 위해서 try로 묶음!
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_task(titl,sdt,edt,mid,tnm) values(?,?,?,?,?)");) {
        
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, task.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, task.getWorker().getId());
            stmt.setString(5, task.getTeam().getName());
            
            
            return stmt.executeUpdate();
        }
    }

    public int update(Task task) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms_task set titl=?,sdt=?,edt=?,mid=?,tnm=? where tano=?");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, task.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, task.getWorker().getId());
            stmt.setString(5, task.getTeam().getName());
            stmt.setInt(6, task.getNo());
            
            return stmt.executeUpdate();
        }
        
    }

    public Task selectOne(int no) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // try() 안에 넣을 수 있는건 객체를 생성하는 변수만 넣을 수 있고 일반 코드는 넣을 수 없다.
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select titl,sdt,edt,stat,mid,tnm from pms_task where tano=?");) {
            
            stmt.setInt(1, no);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) 
                    return null;
            
                Task task = new Task();
                task.setNo(no);
                task.setTitle(rs.getString("titl"));
                task.setStartDate(rs.getDate("sdt"));
                task.setEndDate(rs.getDate("edt"));
                task.setState(rs.getInt("stat"));
                task.setWorker(new Member().setId(rs.getString("mid")));
                task.setTeam(new Team().setName(rs.getString("tnm")));
                // new Team().setName(rs.getString("tnm"))
                // 이렇게 바로 객체에 값을 넣는 방법은 겟터,셋터를 객체를 변경하도록 바꿔주면 된다.
                
                return task;
            }
        }
    }

    public int updateState(int no, int state) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms_task set stat=? where tano=?");) {
            
            stmt.setInt(1, state);
            stmt.setInt(2, no);
            
            return stmt.executeUpdate();
        }
        
    
        
    }
    

    
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





