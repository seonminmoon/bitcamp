package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class TeamMemberDao {

    private Object[][] teamMembers = new Object[1000][2];
    // 주소를 저장하는거기때문에 몇만개 해도 메모리 타격 별로 없음
    private int rowIndex; // 몇번째 행이냐
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase();
        String pmi = memberId.toLowerCase();
        for (int i = 0; i < this.rowIndex; i++) {
            // 입력받은 값 대소문자 구분하지 않게 하기
            if(this.teamMembers[i][0] == null) continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            String mi = ((String)this.teamMembers[i][1]).toLowerCase();
            
            if (tn.equals(ptn) && mi.equals(pmi)) { 
                return i; // 또 등록하면 안되니까 0 을 리턴한다
            }
        }
        return -1;
    }
    
    public int addMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (this.isExist(teamName, memberId)) { // 이미 존재하는 멤버라면 0 리턴
            return 0; 
        }
        this.teamMembers[rowIndex][0] = teamName;
        this.teamMembers[rowIndex][1] = memberId;
        rowIndex++;
        return 1;
    }
    /* 수정 전
        // 입력받은 값 대소문자 구분하지 않게 하기
        String ptn = teamName.toLowerCase();
        String pmi = memberId.toLowerCase();
        for (int i = 0; i < this.rowIndex; i++) {
            // 입력받은 값 대소문자 구분하지 않게 하기
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            String mi = ((String)this.teamMembers[i][1]).toLowerCase();
            
            if (tn.equals(ptn) && mi.equals(pmi)) { 
                return 0; // 또 등록하면 안되니까 0 을 리턴한다
            }
        }
        // 값을 저장할때는 대소문자 구분 안하고 사용자 입력값 그대로 저장한다.
        this.teamMembers[rowIndex][0] = teamName; // rowIndex 의 첫번째에 team 저장
        this.teamMembers[rowIndex][1] = memberId; // rowIndex 의 두번째 방에 member 저장
        rowIndex++; // rowIndex 값 하나 증가시킴
        return 0;
    }
    */
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (index < 0) { // 음수라는 뜻은 찾지 못했다는것. -> 존재하지 않는 멤버이다.
            return 0;
        }
        this.teamMembers[index][0] = null;
        this.teamMembers[index][1] = null;
        return 1;
    }
    
    public boolean isExist(String teamName, String memberId) {
        if (this.getIndex(teamName, memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }
    private int getMemberCount(String teamName) {
        int cnt = 0;
        String ptn = teamName.toLowerCase();
        
        for (int i = 0; i < this.rowIndex; i++) {
            if(this.teamMembers[i][0] == null) continue;
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            if (tn.equals(ptn)) { 
                cnt++;
            }
        }
        return cnt;
    }
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[this.getMemberCount(teamName)]; // 등록된 개수만큼 배열을 준비한다.

        for (int i = 0, x = 0; i < this.rowIndex; i++) {
            if(this.teamMembers[i][0] == null) continue; // 비어있으면 건너 뛰고
            String tn = ((String)this.teamMembers[i][0]).toLowerCase(); // 팀이름을 가져옴
            if (tn.equals(ptn)) { 
                members[x++] = (String)this.teamMembers[i][1]; 
                // 팀멤버이름을 String 으로 형변환 하고 x에 저장 후 ++
            }
        }
        return members;
    }
}
