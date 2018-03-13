// 흐름 제어문 - break 와 continue
package step05;
import java.util.Scanner;

public class Exam03_2 {
    public static void main(String[] args) {

        int count = 0;
        int sum = 0;
        
        // 1부터 100까지의 합은?
        while (count < 100) {
            count++;
            sum += count;
        }
        
        System.out.printf("sum = %d, count = %d \n",sum, count);

        System.out.println("=========================");
        
        // continue 사용 전
        // 1부터 100까지 짝수의 합은?
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count % 2 == 0) {
            sum += count;
            }
        }
        System.out.printf("sum = %d, count = %d \n",sum, count);


        // continue 사용 후
        // 1부터 100까지 짝수의 합은?
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count % 2 == 1) 
                continue; // 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
            sum += count;
            
        }
        System.out.printf("sum = %d, count = %d \n",sum, count);
        System.out.println("=========================");



        // break 사용 전
        // 1부터 100까지 카운터를 하는데 단 합은 50까지만 계산한다.
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count > 50) // 50 넘어가면 합을 수행하지 않는다.
                continue;
            sum += count;
            
        }
        System.out.printf("sum = %d, count = %d \n",sum, count);


        // break 사용 후
        // 1부터 100까지 카운터를 하는데 단 합은 50까지만 계산한다.
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count > 50) 
                break; // 반복문을 나간다.
            sum += count;
            
        }
        System.out.printf("sum = %d, count = %d \n",sum, count);
    }
}