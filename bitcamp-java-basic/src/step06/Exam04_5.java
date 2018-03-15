// 메서드 : 스택 메모리 응용 II - 재귀호출
package step06;
import java.util.Scanner;

public class Exam04_5 {

    static int sum(int value) {
        if (value == 1)
            return 1;

        return value + sum(value - 1);

    }

    public static void main(String[] args) {
        System.out.println(sum(10000));
        System.out.println(sum(100000));
    }  
}
