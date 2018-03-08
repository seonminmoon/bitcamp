// 클래스 - 레퍼런스 배열 - 사용 전
package step03;

public class Exam02_1 {
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
        Score s1,s2,s3;

        // 각 레퍼런스에 인스턴스를 만들어 주소 저장
        s1 = new Score();
        s2 = new Score();
        s3 = new Score();

        // 레퍼런스를 이용하여 인스턴스에 접근한 후 항목에 값 넣기
        s1.name = "홍길동"; // s1에 저장된 주소로 찾아가서 name 항목에 값 저장
        s2.name = "임꺽정";
        s3.name = "유관순";

        // 레퍼런스를 통해 인스턴스의 각 항목 값을 꺼낸다
        System.out.printf("이름 : %s \n",s1.name);
        System.out.printf("이름 : %s \n",s2.name);
        System.out.printf("이름 : %s \n",s3.name);
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

