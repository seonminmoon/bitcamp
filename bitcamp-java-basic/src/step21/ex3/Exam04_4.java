// 던지는 예외  받기 - catch 블록의 순서 
package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam04_4 {
    
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
        if (i < 0)
            throw new Exception();
        else if (i == 1)
            throw new RuntimeException();
        else if (i == 2)
            throw new SQLException();
        else 
            throw new IOException();
    }
    
    public static void main(String[] args) {
        try {
            // try 블록에서 예외가 발생할 수 있는 메서드를 호출한다.
            // catch 블록에서 그 예외를 받아서 처리한다.
            // 메서드가 던지는 예외 개수 만큼 catch 블록을 선언하면 된다.
            m(1);
        } catch (Exception e) { // ex) 자동차 -> 트럭을 받아도 "너 자동차잖아" 라고 퉁 쳐버림
            // 여러 개의 예외를 받을 때 수퍼클래스 변수로 먼저 받지 말라!
            // 그러면 그 클래스의 모든 서브클래스 객체도 다 받게 된다.
            // 즉 서브 클래스의 변수에서 받을 기회조차 없다.
            // => 예외 객체를 정확하게 받고 싶다면 Exam04_3.java 처럼
            //    서브 클래스 예외부터 받아라.
        } catch (IOException e) { // 트럭
            
        } catch (SQLException e) { // 소나타
            
        } catch (RuntimeException e) { // 버스
            
        }
    }
}
