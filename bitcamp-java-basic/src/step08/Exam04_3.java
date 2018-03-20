// 특별한 인스턴스 메서드 - 여러개 생성자 (constructor)
package step08;
public class Exam04_3 {
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        
        Score() {
            System.out.println("Score()");
        }
        Score(String name) {
            System.out.println("Score(String)");
            this.name = name;
        }
        
        Score(String name, int kor, int eng, int math) {
            System.out.println("Score(String,int,int,int) 호출!");
            
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.compute();
        }
        
        public void compute() {
            // 내장 변수 this 에는 compute()를 호출 할 때 넘겨준 인스턴스 주소가 들어 있다.
            this.sum = this.kor + this.eng + this.math;
            this.average = this.sum/3f;
        }
    }
    public static void main(String[] args) {
        Score s1 = new Score();
        Score s2 = new Score("홍길동");
        Score s3 = new Score("장방광", 99, 99, 99);
        
        System.out.printf("%s, %d %d %d %d %.1f \n", 
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.average);
        System.out.printf("%s, %d %d %d %d %.1f \n", 
                s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.average);
        System.out.printf("%s, %d %d %d %d %.1f \n", 
                s3.name, s3.kor, s3.eng, s3.math, s3.sum, s3.average);
    }
}
