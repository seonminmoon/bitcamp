// 사용자 정의 데이터 타입 - 인스턴스 메서드 
package step07;

public class Exam03_1 {
    public static void main(String[] args) {
        // 사용자 정의 데이터 타입의 값을 연산자를 사용하여 다뤄보자!
        Score2 score = new Score2();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
  
        // 다음 연사자는 계산을 수행할 때마다 인스턴스의 주소를 파라미터로 받아야 한다.
        Score2.calculator(score); 
        int i = 10;
        ++i; 

        System.out.printf("%s, %d, %d, %d \n합계, %d, %.1f \n",
                score.name, score.kor, score.eng, score.math, score.sum,
                score.average);

    }
}
