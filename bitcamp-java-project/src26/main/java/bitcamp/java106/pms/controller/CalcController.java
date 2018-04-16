package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component("calc")
public class CalcController implements Controller {
    Scanner keyScan;
    
    public CalcController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("calc")) {
            System.out.print("식을 입력하세요? ");
            String s = keyScan.nextLine();
            String[] arr = s.split(" ");
            int a = Integer.parseInt(arr[0]);
            String op = arr[1];
            int b = Integer.parseInt(arr[2]);
            
            switch (op) {
            case "+":
                System.out.printf("%d + %d = %d",a,b,a+b);
                break;
            case "-":
                System.out.printf("%d - %d = %d",a,b,a-b);
                break;
            case "*":
                System.out.printf("%d * %d = %d",a,b,a*b);
                break;
            case "/":
                System.out.printf("%d / %d = %d",a,b,a/b);
                break;
            case "%":
                System.out.printf("%d % %d = %d",a,b,a%b);
                break;
            default:
                System.out.printf("%s 연산은 지원하지 않습니다", op);
            }
            
            
            
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

}

//ver 23 - 유지보수 테스트를 위해 임시로 만듦.