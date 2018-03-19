// 사용자 정의 데이터 타입 - 메서드 활용
package step07;

public class Exam02_1{
    public static void main(String[] args) {
        // 사용자 정의 데이터 타입의 값을 연산자를 사용하여 다뤄보자!
        Score2 score = new Score2();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        
        // 다음은 Score의 값을 다루는 연산자가 없을 때의 예이다.
        /*
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f;
        */
        
        Score2.calculator(score); // 피연산자 앞에 연산자
        int i = 10;
        ++i; // 피연산자 앞에 연산자 
        
        System.out.printf("%s, %d, %d, %d \n합계, %d, %.1f \n",
                score.name, score.kor, score.eng, score.math,
                score.sum, score.average);

    }
}
