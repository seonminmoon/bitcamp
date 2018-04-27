// Mybatis - SQL에 파라미터로 일반 객체 전달하기
package step25.ex6;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_4 {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex6/mybatis-config07.xml");
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = factory.openSession();
        
        Board board = new Board();
        board.setTitle("제목이래요!");
        board.setContent("내용이래요!");

        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.println("-----------------insert 후--------------------");
        
        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.println(count);
        
        // mybatis는 insert를 실행한 후에 자동 증가된 PK 값(bno 컬럼의 값)을
        // 도로 board 객체에 담아줄 것이다.
        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        
        sqlSession.commit(); 
        
        sqlSession.close();
    }

}











