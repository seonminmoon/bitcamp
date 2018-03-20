import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class ListExample {
 
    public static void main(String[] args) {
        List listA = new ArrayList();
         
        listA.add("김삿갓");
        listA.add("홍아리");
        listA.add(new String("홍길동"));
         
        listA.add(1, "1번째 요소값");
         
         
        // 인덱스를 통한 조회
        String element0 = listA.get(0).toString();
        String element1 = listA.get(1).toString();
        String element3 = listA.get(2).toString();
 
        //Iterator 통한 전체 조회
        Iterator iterator = listA.iterator();
        while (iterator.hasNext()) {
            String element = (String) iterator.next();
             
        }
 
        //for-loop 통한 전체 조회
        for(Object object : listA) {
            String element = (String) object;
        }
         
// 홍길동 앞에 값 추가
        int index = listA.indexOf("홍길동");
        listA.add(index, "홍길동 앞에 값 추가");
 
        // 존재 여부 확인
        System.out.println(listA.contains("홍길동"));
         
        // 값 삭제하는 방법
        System.out.println(listA.remove(0));
        System.out.println(listA.remove("홍길동"));
    }
}

