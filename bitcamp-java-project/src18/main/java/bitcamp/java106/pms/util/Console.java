// 이 클래스는 명령창에서 사용할 기능을 모아 둔 클래스이다.
package bitcamp.java106.pms.util;

import java.util.Scanner;

public class Console {
    // 이 클래스를 사용하기 전에 반드시 Scanner 객체를 설정하라!
    public static Scanner keyScan;

    public static boolean confirm(String message) {
        System.out.printf("%s (y/N)", message);
        String input = keyScan.nextLine().toLowerCase();
        if (input.equals("y")) 
            return true;
        else
            return false;
    }

    public static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }
}
// ver 16
// Console 클래스의 문제점
// Console을 사용하려면 반드시 Scanner 객체가 필요하다.
// - 그러나 스태틱 변수를 강제적으로 설정하게 만들 수 없다.
//
// 해결책
// 1) Scanner 객체를 강제로 설정하게 만드는 방법?
//    => 생성자를 도입하라!
// 2) Console 객첼르 한 개만 새성하게 만드는 방법?
//    => Singleton 설계 패턴으로 Console 클래스를 변경하라!





// cf)
// - 기존의 Console은 keyScan이 스태틱 변수라서 오직 한 기기에 대해서만 읽기를 수행할 수 있었다.
// - 동시에 여러 입력 장치로부터 읽고 싶을 때, 스태틱 변수의 한계 때문에 불가능하다.
// - 해결책? Scanner 입력장치를 여러 개 개별적으로 다루고 싶다면 keyScan 변수를 인스턴스 변수로 만들라!