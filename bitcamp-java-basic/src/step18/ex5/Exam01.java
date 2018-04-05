// 파라미터 정보 알아내기
package step18.ex5;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exam01 {
	
	public void m1(String name, int age) {}
	public void m2() {}
	public void m3(File file, String name) {}
	
	public static void main(String[] args) {
		Class clazz = Exam01.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.printf("%s: \n", m.getName());
			
			// 메서드의 파라미터 정보를 가져온다.
			Parameter[] parameters = m.getParameters();
			for (Parameter p : parameters) {
				System.out.printf("    %s: %s \n",
						p.getName(), p.getType().getName());
				// 파라미터의 이름은 argx 형태로 되어 있다.
				// .class 파일에는 분명히 파라미터 이름이 보관되어 있지만,
				// Reflection API 에서는 보관된 값을 꺼낼 수 없다.
				// 꺼내려면 직접 .class 파일을 읽어서 파라미터 정보를 알알내야 한다.
				//
				// 컴파일할 때 파라미터 이름을 Reflection API 에서 꺼낼 수 있또록
				// 설정해준다면, 그렇다면 원래의 파라미터 이름을 알아낼 수 있다.
				
				// 강사님 코드 참고
			}
		}
		
	}

}
