// Object 클래스의 메서드를 오버라이딩하기 - equals()
package step11.ex12;

public class Exam03_1 {
    
    static class Member {
        String name;
        int age;
        public Member(String name, int age) { // 생성자는 대부분 공개
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
//        Exam09 a = new Exam09();
//        Score obj;
//        obj = a.new Score();
//        이런식으로 인스턴스 주소를 만들어야 인스턴스 변수,메서드에 접근 가능   -> 그래서 지금까지 static 쓴거임
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if (m1 == m2) {
            System.out.println("m1 == m2");
        } else {
            System.out.println("m1 =! m2"); // 출력
        }
        
        // 어? Member 클래스에 equals() 를 정의한적이 없는데 컴파일 오류가 발생하지 않네?
        // 수퍼클래스를 지정하지 않으면 자동으로 Object 상속받음
        // => 자바의 모든 클래스는 Object의 자손이라, Object 의 메소드를 사용할 수 있다.
        
        System.out.println(m1.equals(m2));
        
        // => 상속받은 메소드 중에서 equals() 메소드를 살펴보자!
        // equals()는 String 을 사용할 때 문자열 비교에 사용했던 메서드이다.
        // 두 문자열의 인스턴스가 달라도 내용이 같으면 true 를 리턴했다.
        // 그런데 위의 실행 결과를 보면 m1,m2 인스턴스는 다르지만
        // 내용이 같기 때문에 ture 리턴할 것이라고 예상했는데,
        // 실제 리턴 값은 false 를 리턴한다.
        // 이유?
        // => Object 클래스에서 상속 받아 쓰는 equals()는 원래 내용물을 비교하는게 아니라,
        //    인스턴스가 같은지를 비교하는 메서드이다.
        // => m1,m2 인스턴스가 다르니 당연히 그 결과가 false인 것이다.
        //
        // Member의 내용이 같은지 비교하고 싶은가?
        // => 이럴 때 "오버라이딩" 을 사용하는 것이다.
        // => 즉 Object로부터 상속 받은 메서드가 Member 클래스에 맞지 않다.
        //    그럼 Member클래스에 맞게끔 재정의하면 되는 것이다.
    }
}