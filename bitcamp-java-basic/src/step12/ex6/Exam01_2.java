// java.util.HashMap - 사용자 정의 데이터 타입을 key로 사용할 경우
package step12.ex6;

import java.util.HashMap;

public class Exam01_2 {
    
    static class Mykey {
        String major;
        int no;
        
        public Mykey(String major, int no) {
            this.major = major;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Mykey [major=" + major + ", no=" + no + "]";
        }
        
        
    }

    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 30);
        Member v5 = new Member("윤봉길", 25);
        
        Mykey k1 = new Mykey("컴공", 1);
        Mykey k2 = new Mykey("컴공", 2);
        Mykey k3 = new Mykey("컴공", 3);
        Mykey k4 = new Mykey("컴공", 4);
        Mykey k5 = new Mykey("컴공", 5);
        
        HashMap map = new HashMap();
        
        // 값을 저장할 때 key로 사용할 객체를 지정한다.
        // 보통 key 객체로 String 객체를 많이 사용한다.
        // => 물론 어떤 객체라도 key로 사용할 수 있다.
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        
        // 이전에 저장할 때 사용한 같은 키로 다른 값을 저장하면 기존 값을 덮어쓴다.
        map.put("s04", v5);
        
        System.out.println(map.get(k1));
        System.out.println(map.get(k2));
        System.out.println(map.get(k3));
        System.out.println(map.get(k4));
        System.out.println(map.get(k5));
        
        // 같은 값을 갖지만 인스턴스가 다른 key
        Mykey k6 = new Mykey("컴공", 3); // k3와 같은 값을 갖는다.
                                        // 하지만 인스턴스는 다르다!
        
        System.out.println(map.get(k6));
        // k6 로 값을 찾으면 없다고 나온다.(null)
        // 이유?
        // => HashMap에서 값을 찾을 때 key가 같아야 한다.
        //    key 객체가 다르더라도 hashCode()의 리턴값이 같고,
        //    equals()의 리턴 값이 true이면 두 개의 key는 같다고 간주한다.
        // => 그러나 우리가 사용한 MyKey 클래스는 hashCode(), equals()를 
        //    오버라이딩 하지 않았기 때문에,
        //    값이 같더라도 인스턴스가 다르면 hashCode() 리턴값이 다르게 나온다.
        //    equals() 또한 false를 리턴한다.
        // 해결책?
        // => key로 사용할 클래스는 항상 hashCode()와 equals()를 오버라이딩하여
        //    같은 값을 갖는 객체에 대해 같은 해시값을 리턴하게 해야한다.
    }

}
