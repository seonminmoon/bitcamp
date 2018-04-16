package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
    public ClassroomDao() throws Exception {
        load();
    }

    public void load() throws Exception {
        try (
        ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(
                               new FileInputStream("data/classroom.data")));
        ){
            while (true) {
                try {
                    this.insert((Classroom) in.readObject());
                } catch (Exception e) { // 데이터를 모두 읽었거나 파일 형식에 문제가 있다면,
                    //e.printStackTrace();
                    break; // 반복문을 나간다.
                }
            }
        }
    }

    public void save() throws Exception {
        try ( // catch 는 작성하지 않는다. 발생한 오류는 호출자에게 보내버림
              // 왜냐면 무슨 오류인지 어떻게 해결해야되는지 알아야되기 때문임
              // try 를 빼면 close 가 안되니깐 try는 남겨놓는다.
              // try 빼고 close 만 하면 오류 발생 시 close 까지 가지 않고 오류 넘겨주고 메서드 끝나서 안됨
        ObjectOutputStream out = new ObjectOutputStream(
                                 new BufferedOutputStream(
                                 new FileOutputStream("data/classroom.data")));
        ) {
            Iterator<Classroom> calssrooms = this.list();
            while (calssrooms.hasNext()) {
                out.writeObject(calssrooms.next());
            }
        }
    }
    
    public int indexOf(Object key) {
        int classroomNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




