// 응용 - 2) 자바 CLASSPATH에 있
package step18.ex6;

import java.io.File;
import java.net.URL;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		URL url = classLoader.getResource("step18/ex6");

		File file = new File(url.getPath());
		File[] list = file.listFiles();
		for (File f : list) {
			System.out.println(f.getName());
		}
	}
}
