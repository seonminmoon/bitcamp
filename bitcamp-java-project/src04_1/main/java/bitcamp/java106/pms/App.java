package bitcamp.java106.pms;
import java.util.Scanner;
import java.util.StringTokenizer;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Team[] teams = new Team[1000]; //(),[]?
        int teamIndex = 0;
        Member[] members = new Member[1000];
        int memberIndex = 0;

        while(true) {
        System.out.print("명령> ");
        String[] arr = sc.nextLine().toLowerCase().split(" ");
        String menu = arr[0];
        String option = null;
        if(arr.length == 2) {
            option = arr[1];
        }
            if(menu.toLowerCase().equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equals("help")) {
                System.out.println("명령: help");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
            } else if (menu.equals("team/add")) {
                Team team = new Team();
                System.out.print("팀명? ");
                team.name = sc.nextLine();
                System.out.print("설명? ");
                team.title = sc.nextLine();
                System.out.print("최대인원? ");
                team.num = sc.nextInt();
                sc.nextLine();
                System.out.print("시작일? ");
                team.startDate = sc.nextLine();
                System.out.print("종료일? ");
                team.endDate = sc.nextLine();
                teams[teamIndex++] = team;
            } else if (menu.equals("team/list")) {
                for (int i = 0; i < teamIndex; i++) {
                System.out.printf("%s, %d, %s ~ %s \n",
                teams[i].name, teams[i].num, 
                teams[i].startDate, teams[i].endDate);
                }
            } else if (menu.equals("team/view")) {
                if (option==null) {
                    System.out.println("팀 명을 입력하시기 바랍니다.");
                    continue;
                }
                Team team = null;
                for (int i = 0; i < teamIndex; i++) {
                    if (option.equals(teams[i].name)){
                        team = teams[i];
                        break;
                        }
                    }
                if (team == null) {
                    System.out.println("해당 이름의 팀이 없습니다.");
                } else {
                        System.out.printf("팀명: %s \n",team.name);
                        System.out.printf("설명: %s \n",team.title);
                        System.out.printf("최대인원: %d \n",team.num);
                        System.out.printf("기간: %s ~ %s \n",
                        team.startDate, team.endDate);
                    }
            } else if (menu.equals("member/add")) {
                Member member = new Member();
                System.out.print("아이디? ");
                member.id = sc.nextLine();
                System.out.print("이메일? ");
                member.email = sc.nextLine();
                System.out.print("비밀번호? ");
                member.pw = sc.nextLine();
                members[memberIndex++] = member;
            } else if (menu.equals("member/list")) {
                for (int i = 0; i < memberIndex; i++) {
                System.out.printf("%s, %s, %s \n",
                members[i].id, members[i].email, members[i].pw);
                }
            } else if (menu.equals("member/view")) {
                if (option==null) {
                    System.out.println("회원 아이디를 입력하시기 바랍니다.");
                    continue;
                }
                Member member = null;
                for (int i = 0; i < memberIndex; i++) {
                    if (option.equals(members[i].id)){
                        member = members[i];
                        break;
                        }
                    }
                if (member == null) {
                    System.out.println("해당 아이디의 회원이 없습니다.");
                } else {
                    System.out.printf("id: %s \n",member.id);
                    System.out.printf("email: %s \n",member.email);
                    System.out.printf("pw: %s \n",member.pw);
                }
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
        System.out.println();
        }
    }
}