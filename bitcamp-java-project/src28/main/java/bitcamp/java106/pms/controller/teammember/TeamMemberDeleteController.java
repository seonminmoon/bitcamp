// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/delete")
public class TeamMemberDeleteController implements Controller {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberDeleteController(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            out.printf("%s 팀은 존재하지 않습니다. \n", teamName);
            return;
        }
        
        String memberId = request.getParameter("memberId");
        
        if (!teamMemberDao.isExist(teamName, memberId)) {
            out.println("이 팀의 회원이 아닙니다.");
            return;
        }

        teamMemberDao.deleteMember(teamName, memberId);
        out.println("삭제하였습니다.");
    }
}

//ver 26 - TeamMemberController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.