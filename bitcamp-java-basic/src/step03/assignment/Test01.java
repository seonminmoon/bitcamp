
package step03.assignment;
// < 나 ver. >
// 사용자로부터 입력 받은 성적 데이터(이름, 국어, 영어, 수학)를
// 클래스 문법을 이용하여 저장하라. 또한 평균, 합계를 구하고 정렬해서 출력하라.
// 입력과 출력에 반복문을 적용하라!

public class Test01 {
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        }

        Score arr = new Score[3];

        for(int i = 0; i < arr.length; i++){
            
            Score arr[i] = new Score();
            System.out.print("입력: ");
            arr[i].name = keyScan.next();
            arr[i].kor = keyScan.nextInt();
            arr[i].eng = keyScan.nextInt();
            arr[i].math = keyScan.nextInt();
            arr[i].sum = arr[i].kor + arr[i].eng + arr[i].math;
            arr[i].avg = arr[i].sum/3;
        }
        
        System.out.println("===========================");
      /*  for(int i = 0; i < arr.length; i++){
            System.out.printf("이름 : %s %d %d %d %d %.1f\n",
            arr[i].name, arr[i].kor, arr[i].eng, arr[i].math,
            arr[i].sum, arr[i].avg);
        }*/
    }
}
        