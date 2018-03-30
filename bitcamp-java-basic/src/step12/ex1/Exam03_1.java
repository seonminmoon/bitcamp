// indexOf()의 사용
package step12.ex1;

// 배열을 이용하여 컬렉션 클래스 만들기 : AraayList

public class Exam03_1 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("bbb"); // s2 != s4

        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        print(list);
        System.out.println(list.indexOf(s4));
        System.out.println(list.contains(s4)); // list가 s4을 포함하고 있는가? false
        
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
    
