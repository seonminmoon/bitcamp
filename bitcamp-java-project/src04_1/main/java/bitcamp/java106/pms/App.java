package bitcamp.java106.pms;
import java.util.Scanner;
import java.util.StringTokenizer;
import bitcamp.java106.pms.domain.Team;

public class App {
    public static void main(String[] args){
        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            System.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" "); 
            String menu = arr[0];
            String option = null;

            if (arr.length == 2) {
                option = arr[1];
            }

            if(menu.equals("quit")){
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equals("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                Team team = new Team();
                System.out.print("팀명? ");
                team.name = keyScan.nextLine();
                System.out.print("설명? ");
                team.title = keyScan.nextLine();
                System.out.print("최대인원? ");
                team.num = keyScan.nextInt();
                keyScan.nextLine();
                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                System.out.print("종료일? ");
                team.endDate = keyScan.nextLine();

                teams[teamIndex++] = team;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for ( int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s ~ %s \n",
                    teams[i].name, teams[i].num, 
                    teams[i].startDate, teams[i].endDate);
                }
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                System.out.println(option);
                Team team = null;
                if (option == null) {
                    System.out.println("팀 명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }
                for(int i=0; i< teamIndex; i++) {
                    if(menu.equals(teams[i].name.toLowerCase())) {
                        team = teams[i];
                        break;
                    }
                }
                if (team == null) {
                    System.out.println("해당 이름의 팀이 없습니다.");
                } else {
                    System.out.printf("팀명 : %s \n",team.name);
                    System.out.printf("설명 : %s \n",team.title);
                    System.out.printf("최대인원 : %d \n",team.num);
                    System.out.printf("기간 : %s ~ %s \n",
                    team.startDate, team.endDate);
                }


            }
                System.out.println();

            // System.out.println(input);
        }
    
    }
}