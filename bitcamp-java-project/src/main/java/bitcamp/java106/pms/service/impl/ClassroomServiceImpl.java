// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.service.ClassroomService;

// Component랑 똑같다. 스프링에서는 Service만 제어하고싶을 때 제어할 수 있도록 이름만 달리 해서 만들었음
@Service
public class ClassroomServiceImpl implements ClassroomService {
// 어떤 회사는 DefaultClassroomService (ClassroomService의 기본구현체라는 의미) 라고도 한다.
    ClassroomDao classroomDao;
    // @Autowired 보다는 생성자 만드는걸 추천! 의존객체로 만들자
    
    public ClassroomServiceImpl(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public List<Classroom> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return classroomDao.selectList(params);
    }
    
    @Override
        public Classroom get(int no) {
            return classroomDao.selectOne(no);
        }
    
    @Override
        public int add(Classroom classroom) {
            return classroomDao.insert(classroom);
        }
    
    @Override
        public int update(Classroom classroom) {
            return classroomDao.update(classroom);
        }
   
    @Override
        public int delete(int no) {
            return classroomDao.delete(no);
        }
}
