// 구현체(implementor) - 인터페이스에 따라 만든 클래스
package step14.ex1;

public class BlueWorker implements Worker {
    public void execute() {
        System.out.println("육체 노동자가 일을 합니다!");
    }
}
