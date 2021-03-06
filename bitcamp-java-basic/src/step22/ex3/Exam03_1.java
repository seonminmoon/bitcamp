// 데이터 출력 - long 값  출력
package step22.ex3;

import java.io.FileOutputStream;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        // 우리나라 1년 예산
        long money =  400_0000_0000_0000L; // 400조 = 0x016bcc41e90000
        
        // long 메모리의 모든 바이트를 출력하려면,
        // 각 비트를 맨 끝으로 이동한 후 write()로 출력한다.
        // 왜? write()는 항상 변숭늬 마지막 1바이트만 출력하기 때문이다.
        out.write((int)(money >> 56)); 
        out.write((int)(money >> 48)); 
        out.write((int)(money >> 40)); 
        out.write((int)(money >> 32));
        out.write((int)(money >> 24));
        out.write((int)(money >> 16));
        out.write((int)(money >> 8));
        out.write((int)(money));
        
        out.close();
        System.out.println("출력 완료!");
    }
}
