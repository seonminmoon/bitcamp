// Object 클래스의 메서드를 오버라이딩하기 - equals()
package step11.ex12;

public class Exam03_3 {
    
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
        
        // String 클래스에서 equals()를 오버라이딩 했기 때문에
        // s1.equals(s2)의 결과가 true가 나온것이다.
        
        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");
        System.out.println(sb1 == sb2); // false
        System.out.println(sb1.equals(sb2)); // false
        
        // sb1.equals(sb2)의 리턴 값은 false 이다.
        // 이유?
        // StringBuffer는 Object로부터 상속받은 equals()를 오버라이딩 하지 않았다.
        // 그래서 Object의 equals()가 호출된 것이다.
        // Object의 equals()는 데이터가 같은지를 비교하는 것이 아니라,
        // 인스턴스가 같은지를 비교한다.
    }
}

// 결론!
// => Object로부터 상속 받은 기본 메서드인 equals()는
//    같은 인스턴스인지를 비교하는 메서드이다.
// => 인스턴스의 데이터가 같은지를 비교하고 싶다면, 이 메서드를 재정의(오버라이딩)해야 한다.
// => 오버라이딩의 예:
//    String, 랩퍼 클래스(Byte, long ...강사님꺼 참고)