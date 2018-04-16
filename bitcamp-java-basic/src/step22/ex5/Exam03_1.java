// BufferedInputStream 사용 후 - 데이터 읽는데 걸린 시간 측정
package step22.ex5;

import java.io.FileInputStream;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream("temp/jls8.pdf");
        int b;
        int callCount = 0;
        long startTime = System.currentTimeMillis(); // 밀리초
        while((b = in.read()) != -1) callCount++ ; // 파일을 끝까지 읽는다.
        long endTime = System.currentTimeMillis(); // 밀리초
        

        System.out.println(endTime - startTime);
        System.out.println(callCount);
        
        in.close();
        System.out.println("데이터 출력 완료!");
        
    }
}
