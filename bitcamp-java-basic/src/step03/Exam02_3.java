// 클래스 - 레퍼런스 배열 - 사용 후 + 반복문
package step03;

public class Exam02_3 {
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

        // Score 레퍼런스 여러개 준비
        // => 레퍼런스 배열 준비 (인스턴스 배열이 아니다!)
        Score[] arr = new Score[3];

        // 반복문을 이용하여 레퍼런스 배열에 인스턴스 주소 저장
        for(int i = 0; i < arr.length; i++){
            
           arr[i] = new Score();
        }
        
        // 값을 저장할 때는 일일이 값을 지정해야함
        arr[0].name = "홍길동"; 
        arr[1].name = "임꺽정";
        arr[2].name = "유관순";

        // 반복문을 사용하면 인스턴스의 각 항목 값을 꺼내기 쉽다.
        for(int i = 0; i < arr.length; i++){

            System.out.printf("이름 : %s \n",arr[i].name);
        }
    }
}
// 결론!
// 배열은 반복문과 함께 쓸 때 특히 유용하다.