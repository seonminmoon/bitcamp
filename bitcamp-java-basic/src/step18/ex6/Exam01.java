// 응용 - 1) 자바 CLASSPATH에 있
package step18.ex6;

import java.net.URL;
import java.util.Enumeration;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		// 1) CLASSPATH 를 뒤져서 파일을 찾아줄 객체를 얻는다.
		// => ClassLoader
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		// 2) 특정 패키지나 클래스의 절대 경로를 알아낸다.
		//    => 클래스 로더는 디렉토리나 파일을 찾을 때 JVM에 지정된 CLASSPATH에서 찾는다.
		//       따라서 프로그램을 작성할 때 해당 패키지나 파일이 있는 경로를
		//		 코드에 지정할 필요가 없어 편리하다.
		//    => 자원이 있는 경로를 지정할 때 . 대신 / 를 사용하라!
		//    => getResources() 가 리턴하는 것은 찾은 자원의 경로 정보이다.
		//    => 같은 경로의 자원이 여러 디렉토리에 중복해서 있을 때는
		//       getResources()를 호춣여 여러 개의 경로 정보를 받아라!
		//    => 자원의 경로 정보를 담고 있는 URL
		
		URL url = classLoader.getResource("step18/ex6");

			System.out.println(url.getPath());
			System.out.println(url.getFile());
		
	}
}
