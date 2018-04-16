// DataInputStream을 FileInputStream 이나 ByteArrayInputStream에 붙일 수 있도록
// 기능을 변경한다. DataInputStream 을 장신구로 만든다.
package step22.ex8;

import java.io.IOException;
import java.io.InputStream;

//OutputStream을 상속받아 OutputStream 의 가족으로 거듭난다.
//그러나 InputStream을 상속받았다고 해서 특별히 그 상속받은 기능을 이용하는 것은 아니다.
//단지, 같은 OutputStream 그룹에 소속되기 위함이다.
//=> 이 상속은 기능을 상속받기 위한 것이 아니다.
//같은 그룹으로 묶이기 위함이다.
public class DataInputStream extends InputStream {
    
    InputStream in; // 반드시 선언 후 생성자 준비
                    // 생성자 : 그 객체가 자신의 역할을 제대로 수행하도록 필수 데이터를 준비시키는것
    public DataInputStream(InputStream in) {
        this.in = in;
    }
    
    public String readUTF() throws Exception {
        // 생성자에서 받은 read() 메서드를 사용하여 문자열 출력
        int size = in.read();
        byte[] bytes = new byte[size];
        in.read(bytes);
        return new String(bytes,"UTF-8");
    }
    
    @Override
    public int read() throws IOException {
        return in.read();
    }
    public int readInt() throws Exception {
        // 생성자에서 받은 read() 메서드를 사용하여 int 값 출력
        int value = 0;
        value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        
        return value;
        
    }
    
    public void readLong(long value) throws Exception {
        // 생성자에서 받은 read() 메서드를 사용하여 long 값 출력
        
        value = (long)in.read() << 56;
        value += (long)in.read() << 48;
        value += (long)in.read() << 40;
        value += (long)in.read() << 32;
        value += (long)in.read() << 24;
        value += (long)in.read() << 16;
        value += (long)in.read() << 8;
        value += (long)in.read();
        
    }

    public boolean readBoolean() throws Exception {
        // 생성자에서 받은 read() 메서드를 사용하여 boolean 값 출력
        if (in.read() == 1)
            return true;
        else
            return false;
    }
    public void close() throws IOException {
        in.close();
    }
}
