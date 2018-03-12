// 증감 연산자 : 후위(post-fix) 증감 연산자

package step04;

public class Exam06_2 {
    public static void main(String[] args){
        int i = 7;

        i--; // 7 나중에 빼라~~~~~~~~~~~~
        // 현재 위치에 i 값을 놓고 
        // i 메모리의 값을 1 감소시킨다.

        i--; // 6
        System.out.println(i); // 5
        System.out.println(i--); // 5

        // i = i - 1;
        System.out.println(i);
    }
}
