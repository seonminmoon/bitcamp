package bitcamp.java106.pms.controller;
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;
import bitcamp.java106.pms.util.Console;

public class TeamController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라.    
    // App.keyScan 하는건 쌍방향 참조라서 안됨 - 유지보수에 도움안됨
    public static Scanner keyScan;

    static Team[] teams = new Team[1000];
    static int teamIndex = 0;

    public static void service(String menu, String option) {
            if (menu.equals("team/add")) {
                onTeamAdd();
            } else if (menu.equals("team/list")) {
                onTeamList();
            } else if (menu.equals("team/view")) {
                onTeamView(option);
            } else if (menu.equals("team/update")) {
                onTeamUpdate(option);
            } else if (menu.equals("team/delete")) {
                onTeamDelete(option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
    }

     static void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
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

        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        teams[teamIndex++] = team;
    }

     static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n", 
                teams[i].name, teams[i].maxQty, 
                teams[i].startDate, teams[i].endDate);
        }
    }
     static int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
        
    }
     static void onTeamUpdate(String name) {
        System.out.println("[팀 정보 수정]");
        if (name == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
            return;
        }
        int i = getTeamIndex(name);
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else { 
            Team team = teams[i]; // 팀 정보를 가져오기 (변경 전 값)
            Team updateTeam = new Team(); // (변경 후 저장할 팀)
            System.out.printf("팀명(%s)? ", team.name);
            updateTeam.name = keyScan.nextLine();

            System.out.printf("설명:(%s)? ", team.title);
            updateTeam.title = keyScan.nextLine();

            System.out.printf("최대인원:(%d)? ", team.maxQty);
            updateTeam.maxQty = keyScan.nextInt();
            keyScan.nextLine(); 

            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = keyScan.nextLine();

            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = keyScan.nextLine();
            teams[i] = updateTeam; // 변경사항을 team[i] 로 넣는다.
            
            System.out.println("변경하였습니다.");
        }

    }

     static void onTeamView(String name) {
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }
        int i = getTeamIndex(name);

        if (i == -1) { // getTeamIndex() 에서 -1 을 받았으면
            System.out.println("해당 이름의 팀이 없습니다.");
        } else { // 아니면
            Team team = teams[i]; // 팀정보를 가져온다.
            System.out.printf("팀명: %s\n", team.name);
            System.out.printf("설명: %s\n", team.title);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n", 
                team.startDate, team.endDate);
        }
    }

     static void onTeamDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }
        int i = getTeamIndex(name);
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                teams[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }

}