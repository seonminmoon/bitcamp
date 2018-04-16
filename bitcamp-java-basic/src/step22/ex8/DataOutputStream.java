package step22.ex8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//OutputStream을 상속받아 OutputStream 의 가족으로 거듭난다.
//그러나 InputStream을 상속받았다고 해서 특별히 그 상속받은 기능을 이용하는 것은 아니다.
//단지, 같은 OutputStream 그룹에 소속되기 위함이다.
//=> 이 상속은 기능을 상속받기 위한 것이 아니다.
//같은 그룹으로 묶이기 위함이다.
public class DataOutputStream extends OutputStream {
    
    OutputStream out;
    
    
    public DataOutputStream(OutputStream out) {
        this.out = out;
    }
    
    public void writeUTF(String str) throws Exception {
        // 생성자에서 받은 출력 객체의 write() 메서드를 사용하여 문자열 출력
        byte[] bytes = str.getBytes("UTF-8");
        out.write(bytes.length);
        out.write(bytes);
    }
    
    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }
    public void writeInt(int value) throws Exception {
        // 생성자에서 받은 출력 객체의 write() 메서드를 사용하여 int 값 출력
        out.write(value >> 24);
        out.write(value >> 16);
        out.write(value >> 8);
        out.write(value);
    }
    
    public void writeLong(long value) throws Exception {
        // 생성자에서 받은 출력 객체의 write() 메서드를 사용하여 long 값 출력
        out.write((int)value >> 56);
        out.write((int)value >> 48);
        out.write((int)value >> 40);
        out.write((int)value >> 32);
        out.write((int)value >> 24);
        out.write((int)value >> 16);
        out.write((int)value >> 8);
        out.write((int)value);
        
    }

    public void writeBoolean(boolean value) throws Exception {
        // 생성자에서 받은 출력 객체의  write() 메서드를 사용하여 boolean 값 출력
        if (value)
            out.write(1);
        else
            out.write(0);
    }
    
    public void close() throws IOException {
        out.close();
    }
}
