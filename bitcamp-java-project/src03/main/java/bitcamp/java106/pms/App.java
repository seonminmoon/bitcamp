/*package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Team[] teams = new Team[5];


        System.out.print("팀명? ");
        teams[0].name = sc.nextLine();
        System.out.print("설명? ");
        teams[0].title = sc.nextLine();
        System.out.print("최대인원? ");
        teams[0].num = sc.nextInt();
        sc.nextLine();
        System.out.print("시작일? ");
        teams[0].startDate = sc.nextLine();
        System.out.print("종료일? ");
        teams[0].endDate = sc.nextLine();

        System.out.print("계속 입력하시겠습니까?(Y/N) ");

        System.out.println("======================");
        System.out.printf("%s %d %s ~ %s",teams[0].name, teams[0].num,
        teams[0].startDate, teams[0].endDate);
        
    }
}*/

package bitcamp.java106.pms; // 강사님꺼

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 팀 정보를 받을 메모리 준비
        Team[] team = new Team[5];

        System.out.print("팀명? ");
        team[0].name = keyScan.nextLine();

        System.out.print("설명? ");
        team[0].title = keyScan.nextLine();

        System.out.print("최대인원? ");
        team[0].num = keyScan.nextInt();
        keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                            // 읽고 난 뒤에 아무것도 안하기 때문에 
                            // 일종의 줄바꿈 코드를 제거하는 효과가 있다.

        System.out.print("시작일? ");
        team[0].startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        team[0].endDate = keyScan.nextLine();

        System.out.println("-----------------------------");
        System.out.printf("%s, %d명, %s ~ %s\n", 
            team[0].name, team[0].num, team[0].startDate, team[0].endDate);
    }
}