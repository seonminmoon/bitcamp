// InputStream 에 붙이는 플러그인(Decorator)을 다른 플러그인에 붙이려면,
// 플러그인(decorator) 클래스도 InputStream의 가족이 되어야 한다.
package step22.ex8;

import java.io.IOException;
import java.io.InputStream;

// InputStream을 상속받아 InputStream 의 가족으로 거듭난다.
// 그러나 InputStream을 상속받았다고 해서 특별히 그 상속받은 기능을 이용하는 것은 아니다.
// 단지, 같은 InputStream 그룹에 소속되기 위함이다.
// => 이 상속은 기능을 상속받기 위한 것이 아니다.
//    같은 그룹으로 묶이기 위함이다.
public class BufferedInputStream extends InputStream {
    
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
    
    public void close() throws IOException {
        in.close();
    }
}
