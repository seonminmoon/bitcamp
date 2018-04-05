// 생성자 : 특정 생성자 정보 가져오기
package step18.ex4;

import java.lang.reflect.Constructor;

public class Exam03 {
	
	int value;
	public Exam03(int i) {
		this.value = i;
	}
	
	public void print() {
		System.out.printf("value = %d\n", this.value);
	}
	
	public static void main(String[] args) throws Exception {
		Class clazz = Exam03.class;
		
		// newInstance()는 객체를 생성한 후 기본 생성자를 호출한다.
		// 그래서 Exam03은 기본 생성자가 없기 때문에 실행 오류가 발생한다.
//		Exam03 obj = (Exam03) clazz.newInstance(); // 오류!
		
		// 해결 => 생성자 준비
		Constructor c = clazz.getConstructor(int.class);
		// 생성자 객체를 통해 인스턴스를 생성해야 한다.
		Exam03 obj = (Exam03) c.newInstance(200);
		obj.print();
	}

}
