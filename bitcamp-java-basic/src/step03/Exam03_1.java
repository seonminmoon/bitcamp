// 레퍼런스와 인스턴스 - 가비지 - 강사님 주석 참고
package step03;

public class Exam03_1 {
    public static void main(String[] args){
        // 여러 개의 인스턴스 주소를 저장하기
        class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        }

        // Score 레퍼런스 선언
        Score s1;

        // 인스턴스를 만들어 그 주소를 레퍼런스에 저장한다.
        s1 = new Score();
        
        s1 = new Score(); // 위에 있는 인스턴스는 가비지됨

        // 그러면 기존에 들어있던 주소는 잃어버린다.
        // 주소를 잃어버려 사용할 수 없는 메모리를 가비지라고한다.
        // 가비지는 가비지컬렉터에 의해 메모리에서 해제된다.
        // 가비지 컬렉터(garbage collector) 의 실행
        // - 메모리 부족할 때
        // - CPU 가 한가할 때
        // ...
        

    }
}