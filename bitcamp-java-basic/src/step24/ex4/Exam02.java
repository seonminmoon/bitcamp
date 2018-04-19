// 스레드 생명주기(lifycycle) - join()
package step24.ex4;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        System.out.println("스레드 실행 전");
        
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        };
        t.start();
        
        // 어떤 클래스를 스레드가 종료된 후 실행시키고 싶으면 join 을 활용하면 된다.
        t.join(); // t 스레드가 종료될 때 까지 "main" 스레드는 기다린다.
        
        // 즉 t 스레드가 종료된 후 다음 코드를 실행한다.
        System.out.println("스레드 실행 후");
        
        // 스레드 종료 후 다시 시작시킨다면? 실행 오류!
        // => IllegalThreadStateException 발생!
        // => 즉 종료된 스렏르는 다시 running 할 수 없다.
        t.start();
        
    }
}








