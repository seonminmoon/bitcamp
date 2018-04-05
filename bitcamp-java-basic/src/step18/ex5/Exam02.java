// 리턴 타입 알아내기
package step18.ex5;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class Exam02 {
	
	public String m1(String name, int age) {return null;}
	public char[] m2() {return null;}
	public ArrayList m3(File file, String name) {return null;}
	public void m4() {}
	
	public static void main(String[] args) {
		Class clazz = Exam02.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.printf("%s: \n", m.getName());
			
			Class returntype = m.getReturnType();
			System.out.printf("    리턴: %s\n", returntype.getName());
			
			// 캐릭터 배열 : [C 
			// [C 라는 문자로 리턴한다
		}
		
	}

}
