package step05;

public class Exam01_1 {
    public static void main(String[] args) {
        int age = 18;

        // => if (조건) 문장;
        if (age >= 19) System.out.println("성인이다.");

        if (age >= 19); // if문에 빈 문장을 넣을 수 있다.
            System.out.println("성인이다.");
        // 이런 경우 개발자가 오해할 수 있다.
        // if (조건) 뒤에 문자의 끝을 표시하는 세미콜론을 사용하지 않도록 조심하라!

    }
}