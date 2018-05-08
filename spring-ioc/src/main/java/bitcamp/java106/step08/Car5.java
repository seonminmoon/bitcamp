package bitcamp.java106.step08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Car5 {
    String model;
    String maker;
    int cc;
    Date createdDate;
    boolean auto;
    
    // @Autowired의 required 값은 기본이 true이다.
    // => 즉 의존객체 주입이 필수사항이다.
    // => 선택사항으로 바꾸고 싶으면 false로 설정하라!
    @Autowired(required=false)
    Engine engine;
    
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
