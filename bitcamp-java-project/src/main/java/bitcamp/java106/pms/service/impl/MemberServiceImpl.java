// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

// Component랑 똑같다. 스프링에서는 Service만 제어하고싶을 때 제어할 수 있도록 이름만 달리 해서 만들었음
@Service
public class MemberServiceImpl implements MemberService {
// 어떤 회사는 DefaultMemberService (MemberService의 기본구현체라는 의미) 라고도 한다.
    MemberDao memberDao;
    // @Autowired 보다는 생성자 만드는걸 추천! 의존객체로 만들자
    
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Override
    public List<Member> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return memberDao.selectList(params);
    }
    
    @Override
        public Member get(String id) {
            return memberDao.selectOne(id);
        }
    
    @Override
        public boolean isExist(String id, String password) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("password", password);
            
            // 멤버가 있으면 params 를 보내고(true) 아니면 false
            return memberDao.count(params) > 0 ? true : false;
        }
    
    @Override
        public int add(Member member) {
            return memberDao.insert(member);
        }
    
    @Override
        public int update(Member member) {
            return memberDao.update(member);
        }
   
    @Override
        public int delete(String id) {
            return memberDao.delete(id);
        }
}
