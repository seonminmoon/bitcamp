// Thread를 상속 받기 - 익명 클래스로 구현하기
package step24.ex3;

public class Exam03 {
    public static void main(String[] args) {
        new Thread() { // 익명클래스는 이름이 없기 때문에 정의하자마자 객체를 만든다.
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }.start(); // 생성하자마자 start 실행!
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
    }
}
