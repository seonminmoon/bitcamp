// 흐름 제어문 - else 문의 소속
package step05;

public class Exam01_5 {
    public static void main(String[] args) {
        int age = 19;

        // else 는 가장 가까운 if 에 소속된다.
        // 들여쓰기에 속지 말라!

        if (age >= 19) 
            if (age >= 70)
            System.out.println("지하철 무임승차 가능합니다.");
        else 
            System.out.println("미성년 입니다.");
        
        // if문에 블록을 사용하지 않으면 오직 1개의 문장만 온다고 했는데
        // 위에 코드는 age>19 안에 if와 else 두개 문장이 있잖아요
        // 그럼 컴파일 오류 발생 아닌가요?
        
        // => else 문 if 없이 단독으로 사용할 수 없다.
        // 오직 if 가 있어야만 사용할 수 있다. 따라서 if~else~ 는 한 문장으로
        // 취급한다. 그런 이유로, 위의 if (age >= 70) ~ else ~ 는 한 문장으로
        // 간주한다. 굳이 다음과 같이 중괄호를 사용할 필요 없다.
    }
}