
package step02.assignment;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        double avg = 0;

        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("국어 : ");
        int kor = sc.nextInt();
        System.out.print("영어 : "); 
        int eng = sc.nextInt();
        System.out.print("수학 : ");
        int math = sc.nextInt();

        sum = kor+eng+math;
        avg = sum/3;

        System.out.println("================");
        System.out.printf("%s %d %d %d %d %.2f",name,kor,eng,math,sum,avg);



    }
}

