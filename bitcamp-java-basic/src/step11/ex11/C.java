package step11.ex11;

public class C {
    // 다음은 C의 메서드를 오버라이딩 한게 아니다!
    // 왜? C의 m1은 private 이기 떄문에 오직 C에서만 사용할 수 있다.
    // 그럼 다음 m1() 은? 그냥 C2 에 새로 추가한 메스드이다.
    
        private void m1() {}
        protected void m2() {}
        void m3() {}
        public void m4() {}
}
