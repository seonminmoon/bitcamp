// 메서드의 공개 범위를 public 보다 좁게할 순 없다.
package step14.ex2;

public class Exam02 implements A3{
    // public 보다 좁게 공개 범위를 줄일 수 없다.
    // private void m1() {} // 컴파일 오류!
    // protected void m1() {} // 컴파일 오류!
    // void m1() {} // 컴파일 오류!
    
    // 반드시 public 이어야 한다.
    public void m1() {}
    public void m2() {}
    
}
