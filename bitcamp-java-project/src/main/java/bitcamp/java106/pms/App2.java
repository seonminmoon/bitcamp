package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;

public class App2 {
    static Scanner keyScan = new Scanner(System.in);
    static Team[] teams = new Team[1000];
    static Member[] members = new Member[1000];
    static int teamIndex = 0;
    static int memberIndex = 0;
    static String option = null;
    static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }
    static void onHelp() {
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }
    static void onTeamAdd() {
        Team team = new Team();
        System.out.print("팀명? ");
        team.name = keyScan.nextLine();
        System.out.print("설명? ");
        team.title = keyScan.nextLine();
        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextInt();
        keyScan.nextLine();
        System.out.print("시작일? ");
        team.startDate = keyScan.nextLine();
        System.out.print("종료일? ");
        team.endDate = keyScan.nextLine();
        teams[teamIndex++] = team;
    }
    static void onTeamList() {
        for (int i=0; i < teamIndex; i++) {
            System.out.printf("%s, %d, %s ~ %s \n",
            teams[i].name, teams[i].maxQty,
            teams[i].startDate, teams[i].endDate);
        }
    }
    static void onTeamVeiw() {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
        }
        Team team = null; // 빈 주소, null로 초기화 안해주면 initialized 오류!
        for (int i = 0; i < teamIndex; i++) {
            if (option.toLowerCase().equals(teams[i].name)) { 
                // 변수랑 비교할때는 꼭 equals() 사용!
                team = teams[i];
                break;
            }
        }
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s \n", team.name);
            System.out.printf("설명: %s \n", team.title);
            System.out.printf("최대인원: %s \n", team.maxQty);
            System.out.printf("기간: %s ~ %s \n", 
            team.startDate, team.endDate);
        }
    }
    static void onMemberAdd() {
        Member member = new Member();
        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        System.out.print("암호? ");
        member.password = keyScan.nextLine();
        members[memberIndex++] = member;
    }
    static void onMemberList() {
        for (int i=0; i < memberIndex; i++) {
            System.out.printf("%s, %s, %s \n",
            members[i].id, members[i].email, members[i].password);
        }
    }
    static void onMemberView() {
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
        }
        Member member = null; // 빈 주소, null로 초기화 안해주면 initialized 오류!
        for (int i = 0; i < memberIndex; i++) {
            if (option.toLowerCase().equals(members[i].id)) { 
                // 변수랑 비교할때는 꼭 equals() 사용!
                member = members[i];
                break;
            }
        }
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s \n", member.id);
            System.out.printf("이메일: %s \n", member.email);
            System.out.printf("암호: %s \n", member.password);
        }
    }
    static void onTeamUpdate() {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
        }
        Team team = null; // 빈 주소, null로 초기화 안해주면 initialized 오류!
        int i;
        for (i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (option.toLowerCase().equals(teams[i].name)) {
                // 변수랑 비교할때는 꼭 equals() 사용!
                team = teams[i];
                break;
            }
        }
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            System.out.printf("팀명(%s)? ", team.name);
            updateTeam.name = keyScan.nextLine();
            System.out.printf("설명(%s)? ", team.title);
            updateTeam.title = keyScan.nextLine();
            System.out.printf("최대인원(%s)? ", team.maxQty);
            updateTeam.maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = keyScan.nextLine();
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = keyScan.nextLine();

            System.out.println("정말 변경하시곘습니까? (y,n) ");
            String okok = keyScan.nextLine();
            if (okok.toLowerCase().equals("y")) {
                teams[i] = updateTeam;
                System.out.println("변경되었습니다.");
            }
        }
    }
    static void onTeamDelete() {

        System.out.println("삭제되었습니다.");
    }
    public static void main(String[] args) {
        while(true) {
            String[] arr = prompt();
            String input = arr[0];
            if (arr.length == 2) option = arr[1];
            if (input.equals("help")) { onHelp(); }
            else if (input.equals("quit")) { onQuit(); break; }
            else if (input.equals("team/add")) { onTeamAdd(); }
            else if (input.equals("team/list")) { onTeamList(); }
            else if (input.equals("team/view")) { onTeamVeiw(); }
            else if (input.equals("member/add")) { onMemberAdd(); }
            else if (input.equals("member/list")) { onMemberList(); }
            else if (input.equals("member/view")) { onMemberView(); }
            else if (input.equals("team/update")) { onTeamUpdate(); }
            else if (input.equals("team/delete")) { onTeamDelete(); }
            else {
                System.out.println("안녕히 가세요!");
            }
        System.out.println();
        } //while문 끝
    }
}
