// java.util.ArrayList와 비교
package step12.ex1;
import java.util.ArrayList;

public class Exam01_2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        
        print(list);
        
        list.remove(2);
        print(list);
        
        list.remove(0);
        print(list);

        // list.remove(4);
        // print(list);
        
        list.add(1, "xxx"); // bbb, xxx, ddd,
        list.add(1, "yyy"); // bbb, yyy, xxx, ddd
        list.add(0, "zzz"); // zzz, bbb, yyy, xxx, ddd
        list.add(5, "ttt"); // zzz, bbb, yyy, xxx, ddd
        // 5번 인덱스는 존재하지 않기때문에 변함 없음.
        print(list);
        
        list.set(1, "aaa"); // zzz, aaa, yyy, xxx, ddd
        print(list);
        list.add("ccc"); // zzz, aaa, yyy, xxx, ddd, ccc
        list.add("eee"); // zzz, aaa, yyy, xxx, ddd, ccc, eee
        print(list);
    
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
    
