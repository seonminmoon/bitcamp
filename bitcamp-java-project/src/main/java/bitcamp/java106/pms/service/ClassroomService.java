// 서비스 컴포넌트 - 게시물 업무 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는
    // 업무 용어를 사용하라!
    public abstract List<Classroom> list(int pageNo, int pageSize);
    // public, abstract 는 기본값이라서 생략 가능
    Classroom get(int no);
    int add(Classroom classroom);
    int update(Classroom classroom);
    int delete(int no);
}
