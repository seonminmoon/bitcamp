// 클래스 선언에서 패키지 클래스 사용
package step03;

public class Exam04_1 {
    public static void main(String[] args){
        // 바깥쪽에 별도로 선언한 클래스 사용하기

        Score s1 = new Score();
        Score s2 = s1; 
        s1.name = "홍길동";
        System.out.println(s2.name); 

    }
}

// Exam.04_1.java 컴파일 오류!
// - 다음 명령을 사용하여 소스 파일을 컴파일 하려 하면
//   Score 클래스를 찾을 수 없다고 오류가 발생할 것이다.
//   > javac -encoding UTF-8 -d bin src/step03/Exam04_1.java
// - 이유?
//   Exam04_1.java 에서 Score 클래스를 사용하는데,
//   컴파일 할 때 Score 클래스 정보가 필요하다.
//   그런데 컴파일러 Score 클래스에 대한 정보를 모르기때문에
//   Exam04_1.java 를 제대로 컴파일 할 수 없는 것이다.

// - 해결책?
//   컴파일러에 Score 클래스에 대한 정보를 알려줘라!
//   방법1) Score.class 파일을 갖고 있다면 그 파일이 있는 위치를 알려줘라.
//   > javac -encoding UTF-8 -d bin -classpath bin src/step03/Exam04_1.java.

//   방법2) Score 클래스의 소스파일이 있다면 소스파일의 위치를 알려줘라!
//   > javac -encoding UTF-8 -d bin -sourcepath bin bin src/step03/Exam04_1.java

// 언제 이렇게 해야하는가?
// - 자바에서 기본으로 제공하는 클래스가 아닌 다른 클래스(패키지 클래스)를 사용할 때