package step11.ex11;

public class X4 extends X3 {
    @Override
    void m1() {
        System.out.println("X4의 m1()");
    }
    
    void test() {
        this.m1(); // X4 의 m1()
        super.m1();
        // super.super.m1(); // 컴파일 오류! 이런 문법은 없다!
        
        this.m2(); // X3 의 m2()
        super.m2(); // X3 의 m2()
    }
}
