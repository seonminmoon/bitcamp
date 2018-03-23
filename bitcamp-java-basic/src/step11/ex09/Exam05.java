
//다형성 - 다형적 변수와 형변환 응용 - instanceof 연산자
package step11.ex09;

public class Exam05 {
    
    // Sedan 과 Truck, Bike 의 모든 정보를 자세히 출력하라!
    // 단, 한 개의 메서드로 처리하라!
    
    public static void print(Vehicle v) {
        System.out.println("[기본정보]");
        System.out.printf("모델명: %s \n", v.model);
        System.out.printf("수용인원: %d \n", v.capacity);
        
        // 파라미터 v에 들어있는 주소가 Bike인지 Sedan인지, Truck인지를 구분해서 처리해야 한다.
        // 자바는 이런경우를 대비해 인스턴스의 주소가 어떤 클래스의 주소인지
        // 판단할 수 있는 연산자를 제공한다.
        // instanceof 연산자!
        
        if (v instanceof Bike) {
            Bike bike = (Bike) v;
            System.out.println("[바이크정보]");
            System.out.printf("엔진의 존재여부: %b \n", bike.engine);
        } else if ( v instanceof Car) {
            Car car = (Car) v;
            System.out.println("[자동차 기본정보]");
            System.out.printf("cc: %d \n", car.cc);
            System.out.printf("벨브: %d \n", car.valve);
            if ( v instanceof Sedan) {
            Sedan sedan = (Sedan) v;
            System.out.println("[승용차 기본정보]");
            System.out.printf("썬루프(sunroof): %b \n", sedan.sunroof);
            System.out.printf("자동변속(auto): %b \n", sedan.auto);
            } else if ( v instanceof Truck) {
            Truck truck = (Truck) v;
            System.out.println("[덤프]");
            System.out.printf("덤프가능: %b \n", truck.dump);
            System.out.printf("중량: %.1f \n", truck.ton);
            }
        }
        System.out.println("=========================");
}
    // 다형적 변수를 사용하게 되면 동일한 코드를 갖고 있는 위의 메서드를
    // 한 개의 메서드로 통합할 수 있다.
    // => 즉 Sedan 객체와 Truck 객체를 모두 가리킬 수 있는 레퍼런스를 선언하라!
    //    즉 두 클래스의 상위 클래스의 레퍼런스를 선언하면 된다.
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.model = "비트오토바이2018";
        bike.capacity = 2;
        bike.engine = true;

     Sedan sedan = new Sedan();
     sedan.model = "티코";
     sedan.capacity = 5;
     sedan.cc = 800;
     sedan.valve = 16;
     sedan.auto = true;
     sedan.sunroof = true;
     
     Truck truck = new Truck();
     truck.model = "타이탄II";
     truck.cc = 10000;
     truck.valve = 32;
     truck.dump = true;
     truck.ton = 15;
     
     print(bike);
     print(sedan);
     print(truck);
     
     }
}

