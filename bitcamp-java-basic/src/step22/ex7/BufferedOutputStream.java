// 버퍼 기능을 입출력 플러그인/장신구(decorator)로 전환한다.
package step22.ex7;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream {
    
    OutputStream out;
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(OutputStream out) throws Exception {
        this.out = out;
    }
    
    public void write(int b) throws IOException {
        if(cursor == buf.length) { // 버퍼가 다 차면
            out.write(buf); // 버퍼에 들어있는 데이터를 한번에 출력한다.
            cursor = 0; // 다시 커서를 초기화 시킨다.
        }
        
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할것이다.
        buf[cursor++] = (byte)b;
    }
    public void close() throws IOException {
        this.flush();
        out.close();
    }

    public void flush() throws IOException { // cursor 를 강제로 초기화시킨다.
        if(cursor > 0) {
            out.write(buf, 0, cursor);
            cursor = 0;
        }
    }

}

