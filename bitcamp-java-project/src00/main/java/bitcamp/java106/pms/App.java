package bitcamp.java106.pms; 
//src.main.java 까지는 적으면 안됨, java 폴더 밑에 .java 파일 둘거라서
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("팀명? ");
        String teamName = sc.next();

        System.out.print("설명? ");
        String title = sc.next();

        System.out.print("최대인원? ");
        int num = sc.nextInt();

        System.out.print("시작일? ");
        String startDay = sc.next();

        System.out.print("종료일? ");
        String endDay = sc.next();

        System.out.println("-------------------");
        System.out.println("팀명: " + teamName);
        System.out.println("설명: " + title);
        System.out.println("최대인원: " + num);
        System.out.println("일자: " + startDay + " ~ " + endDay);
    }
} 

