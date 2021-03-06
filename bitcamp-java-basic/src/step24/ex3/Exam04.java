// Runnable 인터페이스 구현 - Thread + 익명 클래스
package step24.ex3;

public class Exam04 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }).start();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
    }
}

