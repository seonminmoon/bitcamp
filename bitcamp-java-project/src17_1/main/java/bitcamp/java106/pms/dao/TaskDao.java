package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    // 몇개의 작업을 담아야 하는지 확인하려는 클래스 만들기 - 여기에서만 사용:private
    private int count(String teamName) { 
        int cnt = 0;
        for (int i = 0; i <taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                cnt++;
            }
        }
        return cnt; // 작업을 전부 담고 리턴
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)]; 
        // 몇개의 배열을 만들어야 하는지 알아야 되기 때문에 count 값 줌
        for (int i = 0, x = 0; i < taskIndex; i++) {
            if(tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
            arr[x++] = tasks[i];
            }
        }
        return arr;
    }
    
    public Task get(String teamName, int taskNo) {
        for (int i = 0; i < taskIndex; i++) {
            if(tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName) &&
                tasks[i].getNo() == taskNo) {
                    return tasks[i];
            }
        }
        return null;
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
            }
    
    public void delete(int i) {
        tasks[i] = null;
    }
}

// ver 17 - 클래스 생성





