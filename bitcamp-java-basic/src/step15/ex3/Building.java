// 디자인 패턴과 추상클래스
package step15.ex3;

public abstract class Building {
    
    public void build() {
        System.out.println("건축하겠습니다!");
        startEffect();
        
        System.out.println("건축이 완료되었습니다!");
        endEffect();
    }
    
    // 템플릿 메서드
    // => 아직 구체적으로 어떤 명령을 실행할 지 정의되지 않은 상태
    //    즉 틀만 갖춘 상태
    // => 추상 메서드를 사용하여 템프릿 메서드를 선언한다.
    public abstract void startEffect();
    public abstract void endEffect();
}
