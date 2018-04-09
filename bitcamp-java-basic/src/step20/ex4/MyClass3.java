// 애노테이션 프로퍼티 값 지정하기 - value 프로퍼티 이름 생략
package step20.ex4;

//@MyAnnotation3(value="홍길동", tel="222-2222") // ok!
@MyAnnotation3("홍길동", tel="222-2222") // value 외 다른 프로퍼티 값도 지정할 경우,
                                        // value 이름 생략 불가!
                                        // value 값만 있을 때 value 값 생략 가능!
public class MyClass3 {
    
}
