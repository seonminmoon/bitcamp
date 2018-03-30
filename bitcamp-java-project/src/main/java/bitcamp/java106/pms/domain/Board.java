package bitcamp.java106.pms.domain;
import java.sql.Date;

public class Board {
    private static int count = 1; 
    // ArrayList 를 사용하게 되었는데, 인덱스가 땡겨지면 전부 다 바뀌기 때문에 
    // 이걸 방지하기 위해서 static 해서 고유번호로 자동 설정
    
    private int no; // 내부적으로 사용
    private String title;
    private String content;
    private Date createdDate;
    
    public Board() {
        this.no = count++; // 고유번호
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
