package step09.assignment;
import java.util.Scanner;
import java.util.Calendar;
// 과제 2018-03-21
/* 
 
사용자로부터 년,월,일 데이터를 입력 받아서
요일과 몇번째 주인지 출력하라!
그리고 1년 중에 몇일 째인지 출력하라!
------------------------------
년,월,일? (예: 2018 3 21)
요일: 수요일
주차: 4주차
일차: 81일차 

        System.out.println(c.get(Calendar.YEAR)); //년도
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); //요일(1 ~ 7)
        System.out.println(c.get(Calendar.WEEK_OF_MONTH)); //그 달의 몇 번째 주
*/
public class test01 {
    
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.println("년,월,일? ");
        int year = keyScan.nextInt();
        int month = keyScan.nextInt();
        int date = keyScan.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year); 
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, date); 
        
        String[] weeks = {"","일","월","화","수","목","금","토"};
        
        System.out.printf("요일: %s요일 \n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("주차: %d주차 \n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("일차: %d일차 \n", c.get(Calendar.DAY_OF_YEAR));
        
    }

}
