
package step03.assignment;  
// < 강사님 ver. 정답확인 >
// 사용자로부터 입력 받은 성적 데이터(이름, 국어, 영어, 수학)를
// 클래스 문법을 이용하여 저장하라. 또한 평균, 합계를 구하고 정렬해서 출력하라.
// 입력과 출력에 반복문을 적용하라!

public class Test01_1 {
    public static void main(String[] args){
        java.util.Scanner keyScan = new java.util.Scanner(System.in);
        
        // Score 메모리(인스턴스)의 주소를 저장할 변수: 레퍼런스 준비
        step03.Score[] scores = new step03.Score[3];

        // 입력 값을 저장할 Score 메모리를 준비한다.
        
        for(int i = 0; i < scores.length; i++){
            scores[i] = new step03.Score();

            System.out.print("입력: ");
            scores[i].name = keyScan.next();
            scores[i].kor = keyScan.nextInt();
            scores[i].eng = keyScan.nextInt();
            scores[i].math = keyScan.nextInt();
            scores[i].sum = scores[i].kor + scores[i].eng + scores[i].math;
            scores[i].aver= scores[i].sum/3;
        }
        System.out.println("===========================");

        for(int i=0; i<scores.length; i++){
            System.out.printf("%s %3d  %3d %3d %3d %.1f \n",
                scores[i].name, scores[i].kor, scores[i].eng, scores[i].math,
                scores[i].sum, scores[i].aver);
        }
    }
}
        