package step05;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("직삼각형의 밑변 길이를 입력하시오: ");
        int len = keyScan.nextInt();
        int count = 1;
        while (count <= len) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            count++;
            System.out.println();
        }

        count = len - 1;
        while (count >= 1) {
            int startCnt = 1;
            while (startCnt <= count) {
                System.out.print("*");
                startCnt++;
            }
            count--;
            System.out.println();
        }
         
    }
}

