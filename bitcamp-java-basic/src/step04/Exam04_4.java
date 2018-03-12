// 비트 이동 연산자 : 응용1

package step04;

public class Exam04_4 {
    public static void main(String[] args){
        int i = 0x27a130ff; // 00100111_10100001_00110000_11111111
        int a,b,c,d;

        System.out.println(Integer.toHexString(i));
        
        // i 변수에 들어있는 값을 1바이트씩(27,a1,30,ff) 잘라서 16진수로 출력하라!
        // a,b,c,d 변수에 넣은 다음 각 변수의 값을 16진수로 출력하라!

        a = i >> 24; // 00000000_00000000_00000000_00100111
        b = (i >> 16) & 0xff; // 0xff 를 사용하면 맨 앞 8자리 비트수만 출력됨(?)
        c = (i >> 8) & 0xff & 0xff;
        d = i & 0xff;
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toHexString(d));
    }
}
