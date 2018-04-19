// 스레드 생명주기(lifycycle) - 강사님 코드
package step24.ex4;

public class Exam01 {
    public static void main(String[] args) {
        
        

        System.out.println("스레드 실행 전");

        new Thread() {
            public void run() {
                // 별도로 분리해서 병행으로 실행할 코드를 두는 곳!
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }.start();
        
        System.out.println("스레드 실행 후");
        // main() 메서드의 호출이 끝나더라도 다른 스레드의 실행이 종료될때까지
        // JVM은 종료되지 않는다.
        
    }
}








