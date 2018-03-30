package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.util.ArrayList;

public class TaskDao {
    private ArrayList collection = new ArrayList();
    
    public void insert(Task task) {
        collection.add(task);
    }
    
    // 몇개의 작업을 담아야 하는지 확인하려는 클래스 만들기 - 여기에서만 사용:private
    private int count(String teamName) { 
        int cnt = 0;
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt; // 작업을 전부 담고 리턴
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)]; 
        // 몇개의 배열을 만들어야 하는지 알아야 되기 때문에 count 값 줌
        for (int i = 0, x = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                arr[x++] = task; 
                // 팀 이름을 받아서 컬렉션을 반복하며 작업 꺼낸다.
                // 작업 안의 팀 이름을 꺼내서 파라미터값과 같다면 그 작업을 arr 에 담는다.
            }
        }
        return arr;
    }
    
    public Task get(int taskNo) {
        int index = this.getTaskIndex(taskNo);
        if(index < 0)
            return null;
        return (Task)collection.get(index);
    }
    
    public void update(Task task) {
        int index = this.getTaskIndex(task.getNo());
        if(index < 0)
            return;
        collection.set(index, task);
    }
    
    public void delete(int taskNo) {
        int index = this.getTaskIndex(taskNo);
        if(index < 0)
            return;
        collection.remove(index);
    }
    
    
    private int getTaskIndex(int taskNo) {
        // taskNo 는 고유한 값을 가지고 있기 때문에 번호만 가지고도 찾을 수 있음
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if(task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }
}

// ver 17 - 클래스 생성





