package step05;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("길이: ");
        int len = keyScan.nextInt();
        int count = 1;
        if(len%2==0) len--;
        int countt = len - 1;
        while (count <= len) {
                int startCnt = 1;
                while (startCnt <= countt) {
                    System.out.print(" ");
                    startCnt++;
                }
                countt --;
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            count += 2;
            System.out.println();
        }

         
        }
    }

/*              강사님꺼 다시 git pull 받아오기
package step05;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("길이: ");
        int len = keyScan.nextInt();
        int sterLen = 1;
        if(len%2==0) len--;
        while (sterLen <= len) {
                int spaceCnt = 1;
                int spaceLen = (len - count) / 2;
            while ( spaceCnt <= spaceLen) {
                System.out.print(" ");
                spaceCnt++;
            }
            int sterCnt = 1;

            while (starCnt <= starLen) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            starLen += 2;
        }
    }
}


*/