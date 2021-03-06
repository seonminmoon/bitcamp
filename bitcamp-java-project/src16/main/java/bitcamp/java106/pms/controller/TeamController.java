// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.java106.pms.dao.TeamDao;

public class TeamController {
     Scanner keyScan;
     TeamDao teamDao;
     
     public TeamController(Scanner scanner, TeamDao teamDao) {
         this.keyScan = scanner;
         this.teamDao = teamDao;
     }
    public void service(String menu, String option) {
        if (menu.equals("team/add")) {
            this.onTeamAdd();
        } else if (menu.equals("team/list")) {
            this.onTeamList();
        } else if (menu.equals("team/view")) {
            this.onTeamView(option);
        } else if (menu.equals("team/update")) {
            this.onTeamUpdate(option);
        } else if (menu.equals("team/delete")) {
            this.onTeamDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }



     void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
        Team team = new Team();

        System.out.print("팀명? ");
        team.setName(this.keyScan.nextLine());

        System.out.print("설명? ");
        team.setDescription(this.keyScan.nextLine());

        System.out.print("최대인원? ");
        team.setMaxQty(this.keyScan.nextInt());
        this.keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.setStartDate(Date.valueOf(this.keyScan.nextLine()));

        System.out.print("종료일? ");
        team.setEndDate(Date.valueOf(this.keyScan.nextLine()));
        teamDao.insert(team);
    }

     void onTeamList() {
        Team[] list = teamDao.list();
        System.out.println("[팀 목록]");
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n", 
                    list[i].getName(), list[i].getMaxQty(), 
                    list[i].getStartDate(), list[i].getEndDate());
        }
    }

     void onTeamView(String name) {
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s\n", team.getName());
            System.out.printf("설명: %s\n", team.getDescription());
            System.out.printf("최대인원: %d\n", team.getMaxQty());
            System.out.printf("기간: %s ~ %s\n", 
                team.getStartDate(), team.getEndDate());
        }
    }

    void onTeamUpdate(String name) {
        System.out.println("[팀 정보 변경]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }

        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            System.out.printf("팀명 : %s \n", team.getName());
            updateTeam.setName(team.getName());
            System.out.printf("설명(%s)? ", team.getDescription());
            updateTeam.setDescription(this.keyScan.nextLine());
            System.out.printf("최대인원(%d)? ", team.getMaxQty());
            updateTeam.setMaxQty(this.keyScan.nextInt());
            this.keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.getStartDate());
            updateTeam.setStartDate(Date.valueOf(this.keyScan.nextLine()));
            System.out.printf("종료일(%s)? ", team.getEndDate());
            updateTeam.setEndDate(Date.valueOf(this.keyScan.nextLine()));
            
            teamDao.update(updateTeam);
            System.out.println("변경하였습니다.");
        }
    }

    void onTeamDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }

        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teamDao.delete(team);
                System.out.println("삭제하였습니다.");
            }
        }
    }
}

// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.