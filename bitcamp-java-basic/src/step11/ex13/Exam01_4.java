// 캡슐화(encapsulation) - 셋터와 겟터
package step11.ex13;

public class Exam01_4 {
    public static void main(String[] args) {
        // 환자 데이터를 등록해보자!
        Customer4 c1 = new Customer4();
        
        // 인스턴스 변수에 직접 접근할 수 없기 때문에 메서드를 통해 값을 넣어야 한다.
        // => Customer3 에는 인스턴스 변수의 값을 설정할 수 있는 setter 가 구비되어 있다.
        c1.setName("홍길동");
        c1.setAge(300);
        c1.setWeight(100);
        c1.setHeight(-50);
        
        System.out.printf("%s %d %d %d \n",
                c1.getName(), c1.getAge(), c1.getWeight(), c1.getHeight());
        
    }

}
