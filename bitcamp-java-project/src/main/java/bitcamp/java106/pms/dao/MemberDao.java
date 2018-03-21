// Member 방 관리
package bitcamp.java106.pms.dao;
import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public void insert(Member member) {
        Member.no = memberIndex;
        this.members[this.memberIndex++] = member;
    }
}
