// 하위 폴더의 파일을 가져온다.
package step19.ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApplicationContext2 {
    private ArrayList<File> list = new ArrayList<>();

    public ApplicationContext2(File dir) {
        findFiles(dir);
    }
    
    private void findFiles(File dir) {
        File[] files = dir.listFiles();
        for(File f : files) {       // 재귀호출
            if (f.isDirectory()) {
                findFiles(f);
            } else {
                list.add(f);
            }
        }
    }
    
    public List<File> getFiles() {
        return this.list;
    }
}
