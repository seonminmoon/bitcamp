package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component("/task")
public class TaskController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;

    public TaskController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
    }

    @RequestMapping("/add")
    public String add(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Task task
            ) throws Exception {
    
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        Team team = teamDao.selectOne(task.getTeam().getName());
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", task.getTeam().getName());
        params.put("MemberId", task.getWorker().getId());
        
        if (task.getWorker().getId().length() > 0 &&
            !teamMemberDao.isExist(params)) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }
        taskDao.insert(task);
        return "redirect:list.do?teamName=" + 
                URLEncoder.encode(teamName, "UTF-8");
            
    }
    @RequestMapping("/form")
    public String form(
            @RequestParam("teamName") String teamName,
            Map<String, Object> map) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        map.put("members", members);
        return "/task/form.jsp";
    }
    
    
    @RequestMapping("/delete")
    public String delete(
            @RequestParam("teamName") String teamName,
            @RequestParam("no") int no) throws Exception {
    
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list.do?teamName=" + 
               URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/list")
    public String list(
            @RequestParam("teamName") String teamName,
            Map<String, Object> map) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Task> list = taskDao.selectList(team.getName());
        map.put("list", list);
        return "/task/list.jsp";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Task task) throws Exception {
        
        task.setTeam(new Team().setName("teamName"));
        task.setWorker(new Member().setId("memberId"));
        
        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        }
        return "redirect:list.do?teamName=" + 
                URLEncoder.encode(teamName, "UTF-8");
            
    }

    @RequestMapping("/view")
    public String view(@RequestParam("no") int no,
            Map<String, Object> map) throws Exception {
        
        Task task = taskDao.selectOne(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        
        List<Member> members = teamMemberDao.selectListWithEmail(
                task.getTeam().getName());
        
        map.put("task", task);
        map.put("members", members);
        return "/task/view.jsp";

    }
    
}

//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - CharacterEncodingFilter 필터 적용.
//         request.setCharacterEncoding("UTF-8") 제거
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
