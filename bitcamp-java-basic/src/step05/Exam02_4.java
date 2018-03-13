// 흐름 제어문 - switch 문법 II
package step05;
import java.util.Scanner;

        // 상수를 좀 더 조직적으로 관리하는 방법
        // => enum 을 사용하여 상수를 정의한다.
        enum Level {
            GUEST2,MEMBER2,ADMIN2
        }

public class Exam02_4 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("사용자 레벨? ");
        int level = keyScan.nextInt();


        // 상수를 사용하지 않았을 때
        // => 값의 의미를 주석으로 달아야만 다른 개발자가 이해할 수 있다.
        switch (level) {
        case 0: // 손님
            System.out.println("조회만 가능 합니다.");
            break;
        case 1: // 일반회원
            System.out.println("글 작성 가능합니다.");
            break;
        case 2: // 관리자
            System.out.println("다른 회원의 글도 변경,삭제 할 수 있습니다.");
            break;
        }

        // 상수를 사용하면 주석없이 바로 이해할 수 있다.
        final int GUEST = 0, MEMBER = 1, ADMIN = 2;
        switch (level) {
        case GUEST: // 손님
            System.out.println("조회만 가능 합니다.");
            break;
        case MEMBER: // 일반회원
            System.out.println("글 작성 가능합니다.");
            break;
        case ADMIN: // 관리자
            System.out.println("다른 회원의 글도 변경,삭제 할 수 있습니다.");
            break;
        }

        // enum 으로 정의된 상수를 사용하려면
        // enum 타입의 변수를 선언해야 한다.
        // => final int 처럼 직접 값을 지정하지 않아도 된다.
        // => 값을 직접 지정할 수도 있다. (나중에 따로 enum 문법에서 설명)
        Level userLevel = Level.MEMBER2;
        switch (userLevel) {
        case GUEST2: // 손님
            System.out.println("조회만 가능 합니다.");
            break;
        case MEMBER2: // 일반회원
            System.out.println("글 작성 가능합니다.");
            break;
        case ADMIN2: // 관리자
            System.out.println("다른 회원의 글도 변경,삭제 할 수 있습니다.");
            break;
        }

        
    }
}