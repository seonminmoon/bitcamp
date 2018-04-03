// 제네릭(Generic) - 사용 후
package step13.ex1;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_2 {
    public static void main(String[] args) {
        
        // 클래스명<타입명>
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
        // ArrayList 선언 시, 지정 타입 아닌 경우에는 컴파일 오류!
        // => 컬렉션에 잘못된 값이 들어갈 상황을 없앨 수 있다.
        //list.add(new String("Hello"));
        //list.add(new Integer(100));
        //list.add(new HashSet());
        
        // 특징2: 제네릭을 지정하면 그와 관련된 메서드의 타입 정보가 자동으로 바뀐다.
        // => 형변환하는 번거로움이 없다.
        Member member = list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        
        // 만약 제네릭이라는 문법이 없다면?
        // 1) 값 꺼낼 때마다 형변환 해야함
        // 2) 형변환 하기 싫다면 값의 종류별로 ArrayList를 만들어야 한다.
        //
        // 제네릭 문법이 존재하므로,
        // => 한 개의 클래스로 여러 타입의 객체를 형변환 없이 다룰 수 있다.
        
    }
}
