// 버퍼 기능을 입출력 플러그인/장신구(decorator)로 전환한다.
package step22.ex7;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream {
    
    InputStream in; 
    
    byte[] buf = new byte[8196];
    int size; // 배열에 저장되어있는 바이트의 수
    int cursor; // 바이트 읽은 배열의 위치
    
    public BufferedInputStream(InputStream in) throws Exception {
        this.in = in;    // InputStream 에다가 BufferedInputStream 덧붙이겠다
    }
    
    public int read() throws IOException {
        if (cursor == size) {
            if ((size = in.read(buf)) == -1) { 
                return -1;
            }
            cursor = 0;
        }
        return 0x000000ff & buf[cursor++];
    }
    
    public void close() throws Exception {
        in.close();
    }
}
