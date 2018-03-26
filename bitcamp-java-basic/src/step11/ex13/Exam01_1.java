// 캡슐화(encapsulation) - 필요한 이유
package step11.ex13;

public class Exam01_1 {
    public static void main(String[] args) {
        // 환자 데이터를 등록해보자!
        Customer c1 = new Customer();
        c1.name = "홍길동";
        c1.age = 300;
        c1.weight = 100;
        c1.height = -50;
        
        // 위의 코드의 문제점을 분석!
        // => 각각의 값이 인스턴스 변수에 들어갈 수 있는 값이기 때문에 컴파일 오류는 발생하지 않는다.
        // => 그러나, "환자"데이터로서 유효한 값은 아니다!
        // => 위의 데이터는 거의 괴물 데이터라 볼 수 있다.
        //    즉 환자를 추상화시킨 목적을 상실한 것이다.
        //    즉 추상화가 무너진 것이다.
        
        // ---------> 강사님 주석 확인
    }

}
