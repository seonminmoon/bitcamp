package bitcamp.java106.pms.domain;
import java.sql.Date;

public class Task {
    // static 변수이기 때문에 매번 생성되지 않고
    // final 이기 때문에한번 바꾸면 바꿀 수 없고
    // public 이라서 공개되어있기때문에 사용할 수 있다
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state; // 0: 작업대기, 1: 작업중, 9: 완료
    private Member worker;
    private Team team;
    
    // public Task() {} 기본 생성자를 호출하지 않음 --> 빈 객체는 만들지 말아라
    // 다른 생성자가 있기 때문에 그 생성자의 조건이 맞아야 Task 를 만들 수 있다.
    
    
    public Task(Team team) {
        this.team = team;
    }
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        this.team = team;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }
    
    
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public Member getWorker() {
        return worker;
    }
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
    
}

// ver 17 - 사용자 정의 데이터 타입 생성