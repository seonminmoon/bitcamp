// 클래스 - 사용 후(식판O) ------------------강사님꺼 참고
package step03;

public class Exam01_2 {
    public static void main(String[] args){
        // 여러개 변수(메모리)를 묶어서 한 사람의 성적 정보를 저장하라!
        // => 밥, 국, 반찬1, 반찬2, 반찬3 을 쟁반에 담아서 가져오는 상황.

        // => 다양한  타입의 메모리를 묶어서 
        // Score 라는 새로운 형태의 메모리를 만들 수 있는 설계도.  
        // => 개발자가 새롭게 정의한 데이터 타입이다.
        // => "사용자 정의 데이터 타입"이라 부른다.
        // => 다음과 같이 클래스 문법을 사용하여 설계도를 정의한다.

        class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
            
        }

        // 개발자가 새롭게 정의한 메모리 설계도에 따라 메모리 준비한다.
        // => Score 설계도에 따라 메모리를 확보하라!
        // => 확보된 메모리를 사용하려면 주소를 보관할 필요가 있다.
        // => 주소를 보관(사물함)하려면 레퍼런스(사물함 번호표)가 필요하다.
        Score s; // Score 설계도에 따라 만든 메모리의 주소를 저장할 변수 = 's' 라는 이름의 별명
        s = new Score(); // Score 설계도에 따라 메모리를 확보하고,
                         // 그 메모리의 주소를 s에 저장한다.

        // 클래스 설계도에 따라 만든 메모리에 값 넣기
        // -> 주소를 이용하여 메모리에 접근함

        s.name = "홍길동"; // s에 저장된 주소로 찾아가서 name 항목에 값 저장
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        s.sum = s.kor + s.eng + s.math;
        s.aver = s.sum / 3;



        // s에 저장된 주소로 찾아가서 name 항목의 값
        // => 위의 말을 줄여서 "s가 가리키는 메모리의 name 항목의 값"
        // => 다른 전문적 용어로 "s가 가리키는 인스턴스의 name 값"
        // => 다시 줄여서 "s 인스턴스의 name 값"
        // => 다른 말로 "s 객체의 name 값"
        System.out.printf("이름 : %s \n",s.name);
        System.out.printf("국어 : %d \n",s.kor);
        System.out.printf("영어 : %d \n",s.eng);
        System.out.printf("수학 : %d \n",s.math);
        System.out.printf("합계 : %d \n",s.sum);
        System.out.printf("평균 : %.1f \n",s.aver);
    }
}

// 클래스(class)
// - 여러 타입의 데이터를 묶어서 사용자 정의 데이터 타입을 만드는 문법
// - 관련된 기능(메서드, 함수)을 관리하기 편하게 묶는 문법이다.

// 배열(array)
// - 단일한 타입의 메모리를 묶는 문법이다.
//
// primitive 변수와 레퍼런스
// - primitive type (byte, short, int, long, float, double, boolean, char)의
//   메모리를 만들 때 변수 선언 만으로 완료된다.
//   변수 이름이 곧 메모리를 가리키는 이름이 된다.
//   예) int age;
// - class(사용자 정의 데이터 타입)으로 메모리를 만들 때는
//   반드시 new 명령을 사용해야 한다.
// - 메모리를 만든 후에는 그 주소를 변수에 저장해서 메모리를 사용한다.
//   예) Score s; <==== 메모리의 주소를 저장하는 변수
//       s = new Score(); <==== 메모리를 확보한 후 그 주소를 s 에 저장.

