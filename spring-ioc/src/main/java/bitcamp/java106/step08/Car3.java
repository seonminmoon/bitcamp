package bitcamp.java106.step08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

// 의존 객체 Engine 주입 - 인스턴스 변수에 @Autowired를 붙여도 된다.
public class Car3 {
    String model;
    String maker;
    int cc;
    Date createdDate;
    boolean auto;
    @Autowired Engine engine;
    
    
    public Car3() {
        System.out.println("Car3()");
    }
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate + ", auto="
                + auto + ", engine=" + engine + "]";
    }

    public Engine getEngine() {
        return engine;
    }
    
    public void setEngine(Engine engine) {
        System.out.println("Car.setEngine()");
        this.engine = engine;
    }

    public boolean isAuto() { 
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
    
}
