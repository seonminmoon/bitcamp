// 강사님꺼 참조! (졸아서 제대로 안씀)

// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package step09;

public class Exam01_1 {

    public static void main(String[] args) {
        // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.
        String s1 = new String("Hello!");
        String s2 = new String("Hello!");
        
        // s1과 s2는 다른 인스터스이다.
        // => 증명
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
        
        // 다른 생성자를 사용하여 스트링 인스턴스를 초기화시키기
        char[] chars = new char[] {'H', 'e', 'l', 'l','o' };
                System.out.printf(%s %s %s \n),s1, s2, s3;
        String s3 = new String(chard)
        byte[] bytes = {(byte)0xb0,(byte)0xa1,(byte)0xb0,(byte)0xa2,
                (byte)0xb6, (byte)0xca, (byte)0xb6}, (byte)0xcb,
        }

}
    
    // 생성자
    // => 인스턴스 변수를 초기화 시키기 위해 여러 개의 생성자를 만들어 
    //  => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용