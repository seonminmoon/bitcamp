// 증감 연산자 : 후위(post-fix) 증가 연산자

package step04;

public class Exam06_1 {
    public static void main(String[] args){
        int i = 2;

        i++; // 2 나중에 증가시켜라~~~~~~~~~~~~
        // 현재 위치에 i 값을 놓고 
        // i 메모리의 값을 1 증가시킨다.

        i++; // 3
        System.out.println(i); // 4
        System.out.println(i++); // 4
    }
}
