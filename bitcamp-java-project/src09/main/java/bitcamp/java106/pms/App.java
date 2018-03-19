//리팩토링
package bitcamp.java106.pms;
import bitcamp.java106.pms.domain.Team;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.controller.TeamController;

import java.util.Scanner;

import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.util.Console;
// ver 0.2 
public class App {
    static Scanner keyScan = new Scanner(System.in);
    static String option = null; 
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
        // 클래스를 사용하기 전에 필수 값을 설정한다.
        TeamController.keyScan = keyScan;
        Console.keyScan = keyScan;
        MemberController.keyScan = keyScan;

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
            } else if (menu.startsWith("team/")) {
                TeamController.service(menu, option);
            } else if (menu.startsWith("member/")) {
                MemberController.service(menu, option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
}