package bitcamp.java106.pms; 
// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일 한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 팀 정보를 받을 메모리 준비
        Team[] arr = new Team[5];
        int j = 0;

        // bitcamp.java106.pms.domain.Team team = new bitcamp.java106.pms.domain.Team(); 
        // => 패키지 클래스 선언 하는게 너무 기니까 import 사용

        for(int i=0; i < arr.length; i++) {
           arr[i] = new Team();
        System.out.print("팀명? ");
        arr[i].teamName = sc.nextLine();
        System.out.print("설명? ");
        arr[i].title = sc.nextLine();
        System.out.print("최대인원? ");
        arr[i].num = sc.nextInt();
        sc.nextLine(); // nextInt 사용 후에 엔터를 입력시키기 위해서
        
        System.out.print("시작일? ");
        arr[i].startDay = sc.nextLine();
        System.out.print("종료일? ");
        arr[i].endDay = sc.nextLine();
        j++;
        System.out.print("계속 입력하시겠습니까? (Y,N) ");
        char c = sc.next().charAt(0);
        sc.nextLine();
        if(c == 'n' || c == 'N') break; 
        }

        System.out.println("-----------------------------");
        
        for(int i = 0; i < j; i++){
        System.out.printf("%s, %d, %s ~ %s\n",arr[i].teamName,
        arr[i].num, arr[i].startDay, arr[i].endDay);
        }

        
    }
} 




/*team.teamName = sc.nextLine();

 System.out.println("-----------------------------");
System.out.printf("%s, %d명, %s ~ %s \n",
    team.naver, team.num, team.startDay, team.endDay)*/