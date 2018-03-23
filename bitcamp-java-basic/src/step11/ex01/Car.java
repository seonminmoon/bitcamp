package step11.ex01;

public class Car {
    public String model;
    public String maker;
    public int capacity;
    
    public Car() {} // 생성자
    
    public Car(String model, String maker, int capacity) { // 또다른 생성자
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
}
