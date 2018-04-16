// OutputStream 에 붙이는 플러그인(Decorator)을 다른 플러그인에 붙이려면,
// 플러그인(decorator) 클래스도 OutputStream의 가족이 되어야 한다.
package step22.ex8;

import java.io.IOException;
import java.io.OutputStream;

//OutputStream을 상속받아 OutputStream 의 가족으로 거듭난다.
//그러나 InputStream을 상속받았다고 해서 특별히 그 상속받은 기능을 이용하는 것은 아니다.
//단지, 같은 OutputStream 그룹에 소속되기 위함이다.
//=> 이 상속은 기능을 상속받기 위한 것이 아니다.
// 같은 그룹으로 묶이기 위함이다.
public class BufferedOutputStream extends OutputStream {
    
    OutputStream out;
    
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(OutputStream out) {
        this.out = out;
    }
    
    public void write(int b) throws IOException {
        if (cursor == buf.length) { // 버퍼가 다차면
            out.write(buf); // 버퍼에 들어있는 데이터를 한 번에 출력한다.
            cursor = 0; // 다시 커서를 초기화시킨다.
        }
        
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할 것이다.
        buf[cursor++] = (byte)b;
    }
    
    public void close() throws IOException {
        this.flush();
        out.close();
    }
    
    public void flush() throws IOException {
        if (cursor > 0) {
            out.write(buf, 0, cursor);
            cursor = 0;
        }
    }
    
}







