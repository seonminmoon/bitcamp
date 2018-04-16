package step22.ex4;

import java.io.FileInputStream;

public class DataInputStream extends FileInputStream {
    
    public DataInputStream(String filename) throws Exception {
        super(filename);
    }
    
    public String readUTF() throws Exception {
        // 상속받은 read() 메서드를 사용하여 문자열 출력
        byte[] buf = new byte[100];
        int size = this.read(buf);
        
        return new String(buf,0,size,"UTF-8");
    }
    
    public int readInt() throws Exception {
        // 상속받은 read() 메서드를 사용하여 int 값 출력
        int value = 0;
        value = this.read() << 24;
        value += this.read() << 16;
        value += this.read() << 8;
        value += this.read();
        
        return value;
        
    }
    
    public void readLong(long value) throws Exception {
        // 상속받은 read() 메서드를 사용하여 long 값 출력
        
        value = (int)this.read() << 56;
        value += (int)this.read() << 48;
        value += (int)this.read() << 40;
        value += (int)this.read() << 32;
        value += (int)this.read() << 24;
        value += (int)this.read() << 16;
        value += (int)this.read() << 8;
        value += (int)this.read();
        
    }

    public boolean readBoolean() throws Exception {
        // 상속받은 read() 메서드를 사용하여 boolean 값 출력
        if (this.read() == 1)
            return true;
        else
            return false;
    }
}
