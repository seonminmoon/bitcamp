package bitcamp.java106.step08;

import java.sql.Date;

public class Car {
    String model;
    String maker;
    int cc;
    Date createdDate;
    boolean auto;
    Engine engine;
    
    
    public Car() {
        System.out.println("Car()");
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
        // 관례! 리턴값이 boolean일 때는 getAuto일 때도 있고, isAuto일 때도 있다.
        return auto;
    }
    public void setAuto(boolean auto) {
        System.out.println("Car.setAuto()");
        this.auto = auto;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("Car.setModel()");
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("Car.setMaker()");
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        System.out.println("Car.setCc()");
        this.cc = cc;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        System.out.println("Car.setCreatedDate()");
        this.createdDate = createdDate;
    }
    
    
    
}
