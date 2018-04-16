// 버퍼 사용 전 - 파일 복사 및 시간 측정 - 버퍼 단위
package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.pdf");
        int readBuffer = 0;
        byte[] buf = new byte[1000];
        
        long startTime = System.currentTimeMillis(); // 밀리초
        while((readBuffer = in.read(buf)) != -1) {
            out.write(buf, 0, readBuffer); // 0번부터 읽은 갯수만큼 출력하라!
        }
        long endTime = System.currentTimeMillis(); // 밀리초
        
        
        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
        System.out.println("데이터 출력 완료!");
        
    }
}
// 데이터 읽기 시간 = average seek time + data transfer time
// 퀀텀 HDD 예)
// average seek time = 0.015초
// data transfer time = 0.00000005초 / 1 byte
//
// 1000 바이트 읽을 때
// 1) 1바이트를 1000번 읽는 경우
//    0.01050005초 * 1000 byte = 10.50005초
// 2) 1000바이트 1번 읽는 경우
//    0.0105 * 0.00000005초 * 1000 byte = 0.01055초
// 1바이트를 여러 번 읽을 경우 매번 바이트의 위치를 찾아야 하기 때문에
// 평균 탐색시간이 누적되어 한 번에 1000 바이트를 읽는 것 보다 시간이 오래 걸린다.
//
// 그러면 RAM에 배열의 크기를 크게 잡으면 좋지 않겠는가?
// => PC 처럼 소수의 프로그램이 동시에 실행될 때는 상관없지만,
//    서버처럼 데이터를 읽는 코드가 동시에 수천개에서 수십만개일 때는
//    아무리 작은 크기의 메모리라도 매우 많아지게 된다.
//    그래서 보통 8KB 정도의 버퍼 크기를 유지하고 있다.
// => 물론 프로그램의 용도나 목적에 따라 버퍼의 크기가 이보다 더 작아지거나
//    커질 수 있다.