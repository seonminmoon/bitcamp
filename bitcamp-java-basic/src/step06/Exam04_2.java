// 메서드 : Heap 메모리 영역
package step06;
import java.util.Scanner;

public class Exam04_2 {
    static int[] getArray() {
        int[] arr = new int[] {100,200,300};
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr;
        arr = getArray();
        System.out.println(arr[1]); // 200
    }  
}

// 1) main() 호출
//    => JVM Stack: args, arr 변수 생성
// 2) getArray() 호출
//    => JVM Stack: arr 변수 생성
//    => Heap: new Int[] 배열 생성
// 3) getArray() 호출 끝
//    => JVM Stack: arr 변수 제거
//    => new int[] 배열 주소 리턴
// 4) main() 호출 끝
//    => JVM Stack : main() 관련 메모리 제거
// 5) JVM 종료
//    => JVM이 사용한 모든 메모리 (Method Area, JVM Stack, Heap) 반납