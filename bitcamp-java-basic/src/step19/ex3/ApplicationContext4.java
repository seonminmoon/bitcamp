// 중첩 클래스를 제외하고, .class 파일만 추출한다. 
package step19.ex3;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 {
    private ArrayList<File> list = new ArrayList<>();

    public ApplicationContext4(String packageName) {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (!dir.isDirectory())
            return;
        
        findFiles(dir);

    }
    
    private void findFiles(File dir) { // 필터 추가
    File[] files = dir.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory() || // 디렉토리 이거나 
                    (pathname.getName().endsWith(".class") && // 클래스 파일인 경우 
                    !pathname.getName().contains("$"))) { // 단, 중첩클래스는 제외
                return true;
            }
            return false;
        }
    });
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
