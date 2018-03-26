// Object 클래스의 메서드를 오버라이딩하기 - equals()
package step11.ex12;

public class Exam03_2 {
    
    static class Member /* extends Object */ {
        String name;
        int age;
        public Member(String name, int age) { // 생성자는 대부분 공개
            this.name = name;
            this.age = age;
        }
        // Object 로부터 상속받은 equals() 메서드를
        // Member 클래스의 역할에 맞게 재정의해보자!
        
//        여기서 커서 대고 ctr + 스페이스 누르면 상속받은 클래스 전부 나옴!!
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Member)) // obj가 Member의 자식이 아니라면
                return false; // false를 리턴해라
            Member other = (Member) obj;
            
            if(!this.name.equals(other.name))
                return false;
            
            if(this.age != other.age)
                return false;
            
            return true;
        }
    }
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if (m1 == m2) {
            System.out.println("m1 == m2");
        } else {
            System.out.println("m1 =! m2"); 
        }
        
        
        System.out.println(m1.equals(m2));
        
    }
}

// 결론!
// => Object로부터 상속 받은 기본 메서드인 equals()는
//    같은 인스턴스인지를 비교하는 메서드이다.
// => 인스턴스의 데이터가 같은지를 비교하고 싶다면, 이 메서드를 재정의(오버라이딩)해야 한다.
// => 오버라이딩의 예:
//    String, 랩퍼 클래스(Byte, long ...강사님꺼 참고)