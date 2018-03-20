//클래스 용도 - 소스 코드를 관리하기 쉽게 관련된 기능을 묶을 때 사용
package step07; // 소스폴더 포함하지 않는 그 밑 폴더부터 적는다
public class ExamY_1 {
    public static void main(String[] args) {
        int result = 0;
        
        // 2 + 3 - 1 * 7 / 3 = ?
        // => 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        result = Calculator.plus(2, 3);
        result = Calculator.minus(result, 1);
        result = Calculator.multiple(result, 7);
        result = Calculator.divide(result, 3);
        
        System.out.printf("result = %d \n", result);
        

    }
}
