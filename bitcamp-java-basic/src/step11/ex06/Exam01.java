// 상속 - 생성자 호출 순서
package step11.ex06;

public class Exam01 {
    public static void main(String[] args) {
        C obj2 = new C();
        obj2.v1 = 100;
        obj2.v2 = 200;
        obj2.v3 = 300;
        System.out.printf("v1=%d v2=%d v3=%d \n",obj2.v1, obj2.v2, obj2.v3);
        // 생성자 호출 순서 - 강사님 참고
        
    }
}
