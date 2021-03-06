package bitcamp.java106.pms;     // 강사님꺼 +변수이름바꿈 + for문 + if문

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App2_2 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 팀 정보를 받을 메모리 준비
        Team[] teams = new Team[5];
        int count = 0;

        for ( int i = 0; i < teams.length; i++) {
            count++;
            teams[i] = new Team();      
            // 객체에 주소를 저장한다. (줄여서: 객체를 저장한다)

            System.out.print("팀명? ");
            teams[i].teamName = keyScan.nextLine();

            System.out.print("설명? ");
            teams[i].title = keyScan.nextLine();

            System.out.print("최대인원? ");
            teams[i].num = keyScan.nextInt();
            keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                                // 읽고 난 뒤에 아무것도 안하기 때문에 
                                // 일종의 줄바꿈 코드를 제거하는 효과가 있다.
            System.out.print("시작일? ");
            teams[i].startDay = keyScan.nextLine();

            System.out.print("종료일? ");
            teams[i].endDay = keyScan.nextLine();
            
            System.out.print("계속하시겠습니까?(y/n) ");
            String str = keyScan.nextLine();

            if (count == teams.length) break; 
            // if (i == teams.length-1) break;   --> i는 0부터시작, count는 1부터 시작이기 때문에
            
            if (str.toLowerCase().equals("n")) {              
                //toLowerCase : 대소문자 모두 소문자로 바꿔줌
                //equals      : 글자 비교하는 명령어
                break;
            }
        }

        System.out.println("-----------------------------");
        
        for ( int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", 
                teams[i].teamName, teams[i].num, teams[i].startDay, teams[i].endDay);
        }
    }
}