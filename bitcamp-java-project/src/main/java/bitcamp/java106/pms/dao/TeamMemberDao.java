package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    
    private HashMap<String, ArrayList<String>> collection;
 
    public TeamMemberDao() throws Exception {
        load();
    }
    
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        try (
        ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(
                               new FileInputStream("data/teammember.data")));
        ){
            
            try {
                collection = (HashMap<String, ArrayList<String>>) in.readObject();
            } catch (Exception e) {
                // 데이터를 읽다가 오류가 발생하면 빈 해시맵 객체를 만든다.
                collection = new HashMap<>();
            }
        }
    }

    public void save() throws Exception {
        try ( // catch 는 작성하지 않는다 => 발생한 오류는 호출자에게 보내버리기 위함
              // 왜냐면 무슨 오류인지 어떻게 해결해야되는지 알아야되기 때문이다.
              // try 를 빼면 close 가 안되니깐 try는 남겨놓는다.
              // try 빼고 close 만 하면 오류 발생 시 close 까지 가지 않고 오류 넘겨주고 메서드 끝나서 안됨
        ObjectOutputStream out = new ObjectOutputStream(
                                 new BufferedOutputStream(
                                 new FileOutputStream("data/teammember.data")));
        ) {
            out.writeObject(collection); // 다른 Dao들도 collection 통째로 보내도 상관없다.
        }
    }
    
    
    public int addMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null) { // 해당 팀의 멤버가 추가된 적이 없다면,
            members = new ArrayList<>();
            members.add(memberIdLC);
            collection.put(teamNameLC, members);
            return 1;
        }
        
        // ArrayList에 해당 아이디를 가진 멤버가 들어 있다면,
        if (members.contains(memberIdLC)) {
            return 0;
        }
        
        members.add(memberIdLC);
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) 
            return 0;

        members.remove(memberIdLC);
        return 1;
    }
    
    public Iterator<String> getMembers(String teamName) {
        ArrayList<String> members = collection.get(teamName.toLowerCase());
        if (members == null)
            return null;
        return members.iterator();
    }
    
    public boolean isExist(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) 
            return false;
        
        return true;
    }
}

// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 17 - 클래스 추가









