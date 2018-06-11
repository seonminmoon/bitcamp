// 업무로직 구현체 - 고객사마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.service.TaskService;

// Component랑 똑같다. 스프링에서는 Service만 제어하고싶을 때 제어할 수 있도록 이름만 달리 해서 만들었음
@Service
public class TaskServiceImpl implements TaskService {
// 어떤 회사는 DefaultTaskService (TaskService의 기본구현체라는 의미) 라고도 한다.
    TaskDao taskDao;
    // @Autowired 보다는 생성자 만드는걸 추천! 의존객체로 만들자
    
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    
    @Override
    public List<Task> list(String teamName, int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("teamName", teamName);
        
        return taskDao.selectList(params);
    }
    
    @Override
        public Task get(int no) {
            return taskDao.selectOne(no);
        }
    
    @Override
        public int add(Task task) {
            return taskDao.insert(task);
        }
    
    @Override
        public int update(Task task) {
            return taskDao.update(task);
        }
   
    @Override
        public int delete(int no) {
            return taskDao.delete(no);
        }
}
