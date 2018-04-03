package step11.ex18;

public abstract class Car {

    public Car() {
        super();
    }

    public void start() {
        System.out.println("시동 건다!");
    }

    public void shutdown() {
        System.out.println("시동 끈다!");
    }

    // 추상 메서드
    // => 서브 클래스에서 재정의할 메서드라면 굳이 수퍼 클래스에서 구현하지 말라!
    // => 또는 서브 클래스가 구현하도록 강제하고 싶다면 그때 해당 메서드를 추상 메서드로 선언한다.
    // => 추상 메서드를 상속 받는 서브클래스는 반드시 구현해야 한다.
    //    만약 구현하지 않으면 서브클래스도 추상클래스가 되어야 한다.
    // => 왜? 추상 메서드가 있다는 것은 해당 메서드를 실행할 수 없다는 것이고
    //       실행할 수 없는 메서드를 갖는 클래스는 인스턴스를 생성해서는 안되기 때문에
    //       일반 클래스는 추상메서드를 가질 수 없다.
    public abstract void run() {
    }

}