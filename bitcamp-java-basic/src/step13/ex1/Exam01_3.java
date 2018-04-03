// 제네릭(Generic) - 문법 정리
package step13.ex1;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_3 {
    public static void main(String[] args) {
        // 문법
        // => 클래스명 옆에 다루고자 하는 타입의 이름을 지정한다.
        //    클래스명<타입명>
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
        // ArrayList 선언 시, 지정 타입 아닌 경우에는 컴파일 오류!
        // => 컬렉션에 잘못된 값이 들어갈 상황을 없앨 수 있다.
        //list.add(new String("Hello"));
        //list.add(new Integer(100));
        //list.add(new HashSet());
        
        // 레퍼런스에 제네릭 정보가 있다면 new 연산자에서는 생략할 수 있다.
        ArrayList<Member> list2 = new ArrayList</* Member */>();
        ArrayList<Member> list3;
        list3 = new ArrayList<>();
        
        // 레퍼런스 변수를 선언할 때는 타입명을 생략할 수 없다.
        // ArrayList<> list4; // 컴파일 오류!
    }
}
