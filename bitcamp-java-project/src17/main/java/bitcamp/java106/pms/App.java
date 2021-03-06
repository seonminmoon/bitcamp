package bitcamp.java106.pms;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TaskController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.TeamMemberController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class App {
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) {
        TeamDao teamDao = new TeamDao();
        MemberDao memberDao = new MemberDao();
        TaskDao taskDao = new TaskDao();
        
        // 테스트용 데이터를 준비하도록 다음 메서드를 호출
        prepareMemberData(memberDao);
        prepareTeamData(teamDao, memberDao);
        
        TeamController teamController = new TeamController(keyScan, teamDao);
        TeamMemberController teamMemberController = new TeamMemberController(keyScan, teamDao, memberDao);
        MemberController memberController = new MemberController(keyScan, memberDao);
        BoardController boardController = new BoardController(keyScan);
        TaskController taskController = new TaskController(keyScan, teamDao, taskDao);
        
        Console.keyScan = keyScan;

        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if (menu.startsWith("team/member/")) {
                teamMemberController.service(menu, option);
            } else if (menu.startsWith("team/")) {
                teamController.service(menu, option);
            } else if (menu.startsWith("member/")) {
                memberController.service(menu, option);
            } else if (menu.startsWith("board/")) {
                boardController.service(menu, option);
            } else if (menu.startsWith("task/")) {
                taskController.service(menu, option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
    static void prepareMemberData(MemberDao memberDao) {
        Member member = new Member(); // 테스트하기 위한 멤버 5명 추가
        member.setId("aaa");
        member.setEmail("aaa@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("bbb");
        member.setEmail("bbb@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ccc");
        member.setEmail("ccc@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ddd");
        member.setEmail("ddd@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("eee");
        member.setEmail("eee@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
    }
    
    static void prepareTeamData(TeamDao teamDao, MemberDao memberDao) {
        Team team = new Team();
        team.setName("t1");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-1-1"));
        team.setEndDate(Date.valueOf("2018-5-30"));
        team.addMember(memberDao.get("aaa")); // id=aaa 인 사람 찾아서 team에 추가
        team.addMember(memberDao.get("bbb"));
        team.addMember(memberDao.get("ccc"));
        teamDao.insert(team);

        team = new Team();
        team.setName("t2");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-2-1"));
        team.setEndDate(Date.valueOf("2018-6-30"));
        team.addMember(memberDao.get("ccc"));
        team.addMember(memberDao.get("ddd"));
        team.addMember(memberDao.get("eee"));
        teamDao.insert(team);
    }
}