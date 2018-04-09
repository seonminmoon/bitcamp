// 전체파일 
package step19.ex4;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext5 {
    private ArrayList<String> list = new ArrayList<>();

    public ApplicationContext5(String packageName) {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (!dir.isDirectory())
            return;
        
        findFiles(dir, packageName);

    }
    
    // 파일 경로에서 패키지 명과 클래스 명을 추출할 수 없다.
    // 그래서 파일을 찾을 때 패키지 이름을 따로 관리해야한다.
    private void findFiles(File dir, String packageName) { 
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
                findFiles(f, packageName + "." + f.getName());
            } else {
                String classname = f.getName();
                list.add(packageName + "." +    // .class 없애기
                        classname.substring(0, classname.length() - 6));
            }
        }
    }
    
    public List<String> getFiles() {
        return this.list;
    }
}
