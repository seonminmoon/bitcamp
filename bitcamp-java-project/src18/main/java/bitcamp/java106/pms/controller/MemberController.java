// 이 클래스는 회원 관련 기능을 모두 둔 클래스이다.
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class MemberController {
    Scanner keyScan;
    MemberDao memberDao;
 
    public MemberController(Scanner scanner, MemberDao memberDao) {
        this.keyScan = scanner;
        this.memberDao = memberDao;
    }
    public void service(String menu, String option) {
        if (menu.equals("member/add")) {
            onMemberAdd();
        } else if (menu.equals("member/list")) {
            onMemberList();
        } else if (menu.equals("member/view")) {
            onMemberView(option);
        } else if (menu.equals("member/update")) {
            onMemberUpdate(option);                
        } else if (menu.equals("member/delete")) {
            onMemberDelete(option);                
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
     
     void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.setId(this.keyScan.nextLine());

        System.out.print("이메일? ");
        member.setEmail(this.keyScan.nextLine());

        System.out.print("암호? ");
        member.setPassword(this.keyScan.nextLine());

        // 회원 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        // this.members[this.memberIndex++] = member;
        memberDao.insert(member);
    }

     void onMemberList() {
        System.out.println("[회원 목록]");
        Member[] list = memberDao.list();
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%s, %s, %s\n", 
                list[i].getId(), list[i].getEmail(), list[i].getPassword());
        }
    }

     void onMemberView(String id) {
        System.out.println("[회원 정보 조회]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s\n", member.getId());
            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("암호: %s\n", member.getPassword());
        }
    }

     void onMemberUpdate(String id) {
        System.out.println("[회원 정보 변경]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }

        Member member = memberDao.get(id);

        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member updateMember = new Member();
            System.out.printf("아이디: %s \n", member.getId());
            updateMember.setId(member.getId());
            System.out.printf("이메일(%s)? ", member.getEmail());
            updateMember.setEmail(this.keyScan.nextLine());
            System.out.printf("암호? ");
            updateMember.setPassword(this.keyScan.nextLine());
            
            memberDao.update(updateMember);
            System.out.println("변경하였습니다.");
        }
    }

    void onMemberDelete(String id) {
        System.out.println("[회원 정보 삭제]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }

        Member member = memberDao.get(id);

        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                memberDao.delete(id);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}