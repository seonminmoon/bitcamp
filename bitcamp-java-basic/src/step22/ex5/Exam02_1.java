// 버퍼 사용 전 - 파일 복사 및 시간 측정 - 바이트 단위
package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_2.pdf");
        int b = 0;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        while((b = in.read()) != -1) {
            out.write(b);
        }
        long endTime = System.currentTimeMillis(); // 밀리초
        

        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
        System.out.println("데이터 출력 완료!");
        
    }
}
