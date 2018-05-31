package bitcamp.java106.step12.ex4;

import java.util.List;
import java.util.Map;

import bitcamp.java106.step12.Board;

public interface BoardDao {
    // 이 인터페이스의 구현체를 mybatis가 자동으로 생성하여 Spring IoC 컨테이너에 등록할 것이다.
    // 그러려면 메서드를 만들 때 몇 가지 규칙을 따라야 한다.
    // 1) 맵퍼 파일의 namespace는 인터페이스의 패키지 및 인터페이스 명과 같아야 한다.
    //    예) <mapper namespace="bitcamp.java106.step12.ex4.BoardDao">
    // 2) 메서드의 이름과 SQL 아이디가 같아야 한다.
    // 3) 메서드의 리턴 타입과 SQL 맵퍼 파일의 resultType 또는 resultMap이 같아야 한다.
    //    insert, update, delete 일 경우 리턴 값이 void 또는 int가 될 수 있다.
    // 4) SQL 맵퍼는 파라미터 값을 한 개만 받기 때문에 DAO 인터페이스에서도
    //    SQL 맵퍼의 파라미터와 일치하는 같은 타입의 값을 한 개만 선언해야 한다.
    //
    public List<Board> selectList(Map<String, Object> map);
    public int insert(Board board);
    public int delete(int no);
}


//ver 33 - Mybatis 적용 
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





