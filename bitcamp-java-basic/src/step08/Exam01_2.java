// 인스턴스 변수 응용 - 성적 데이터 저장할 메모리 만들기
package step08;

public class Exam01_2 {
    public static void main(String[] args) {
         // 1) 성적 데이터를 설계할 클래스이기 때문에 그에 맞는 클래스명을 사용하라!
        class Score {
            // 2) 여러 명의 구별되는 성적 데이터를 저장해야 하기 때문에 
            //    인스턴스 변수로 메모리를 설계하라!
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float average;
        
        }
        
        // 저장하고 싶은 데이터 개수 만큼 인스턴스(=개별 데이터)를 생성하라!
        Score s1 = new Score(); // 1명 분의 성적 데이터를 저장할 메모리
        Score s2 = new Score();
        Score s3 = new Score();
        
        // 각 인스턴스에 한 명의 성적 데이터를 저장하라! --> Heap 에 저장됨
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.average = s1.sum / 3f;
        
        s2.name = "홍길동";
        s2.kor = 100;
        s2.eng = 90;
        s2.math = 80;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.average = s2.sum / 3f;
        s2.name = "홍길동";
        
        s3.kor = 100;
        s3.eng = 90;
        s3.math = 80;
        s3.sum = s3.kor + s3.eng + s3.math;
        s3.average = s3.sum / 3f;
    }
}


