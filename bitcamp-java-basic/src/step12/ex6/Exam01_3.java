// java.util.HashMap - 사용자 정의 데이터 타입을 key로 사용할 경우 - 오버라이딩 둘다 했음
package step12.ex6;

import java.util.HashMap;

public class Exam01_3 {
    
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((major == null) ? 0 : major.hashCode());
            result = prime * result + no;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Mykey other = (Mykey) obj;
            if (major == null) {
                if (other.major != null)
                    return false;
            } else if (!major.equals(other.major))
                return false;
            if (no != other.no)
                return false;
            return true;
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
        
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        
        map.put("s04", v5);
        
        System.out.println(map.get(k1));
        System.out.println(map.get(k2));
        System.out.println(map.get(k3));
        System.out.println(map.get(k4));
        System.out.println(map.get(k5));
        
        Mykey k6 = new Mykey("컴공", 3); // k3와 같은 값을 갖는다.
                                        // 하지만 인스턴스는 다르다!
        
        System.out.println(map.get(k6));
        // hashCode() 리턴 값 같고, eqauls()의 결과가 true --> 같은 key 로 간주한다.
        //
        // 결론!
        // - HashMap의 key 객체로 사용할 클래스는 반드시 hashCode()와 equals()를
        //   오버라이딩 하여 같은 값을 갖는 경우 같은 해시 값을 리턴하게 하라!
        // - 대부분 현업에서는 그냥 String을 key로 사용한다.
        //   또는 Wrapper 클래스인 Integer를 사용하기도 한다.
    }

}
