package step22.ex5;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(String filename) throws Exception {
        super (filename);
    }
    
    @Override
    public void write(int b) throws IOException {
        if(cursor == buf.length) { // 버퍼가 다 차면
            this.write(buf); // 버퍼에 들어있는 데이터를 한번에 출력한다.
            cursor = 0; // 다시 커서를 초기화 시킨다.
        }
        
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할것이다.
        buf[cursor++] = (byte)b;
    }
    
    @Override
    public void close() throws IOException {
        this.flush();
        super.close();
    }

    @Override
    public void flush() throws IOException { // cursor 를 강제로 초기화시킨다.
        if(cursor > 0) {
            this.write(buf, 0, cursor);
            cursor = 0;
        }
    }
}


/*
                    <<<<< 오류 발생 >>>>>>

    public void write(int b) throws IOException {...}
    
    만약 복사할 파일 사이즈가 1200 이고, buf 사이즈가 1000 일 때
    마지막으로 복사된 buf 사이즈가 200 인데 출력 조건이 '버퍼가 다 차면' 이기 때문에 
  200은 출력되지 못하고 close 하는 오류가 발생!
    
    
    해결책? 
    1) close 메서드 오버라이딩 해서 close 하기 전에 남은 찌꺼기 데이터까지 넘겨준다.
    2) flush 메서드 오버라이딩 해서 cursor의 위치를 초기화해준다.
    3) 중복코드 쓸 필요 없으니까 flush 에 찌꺼기 넘겨주는 데이터 합치고, close 메서드에 flush 메서드 호출!
    
    * 원래부터 있던 flush 메서드의 역할?
    * 버퍼가 있으면 버퍼에 남은 데이터도 파일에 출력시켜라
    * 
    
*/

