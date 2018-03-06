// 배열
package step02;

public class Exam09_1 {
    public static void main(String[] args){
        //배열 사용 전
        int i1, i2, i3, i4, i5;
        
        //배열 선언
        int[] arr1 = new int[5]; // ok!
        int arr2[] = new int[5]; // ok! C-style

        //배열 메모리에 접근
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;
        arr[3] = 400;
        arr[4] = 500;

        // 유효하지 않은 인덱스 지정한다면?
        arr[5] = 600;
    }
}

// 배열?
// - 같은 종류의 메모리를 쉽게 만드는 방법
// - 문법
//   메모리종류[] 메모리이름 = new 메모리종류[개수]
//   데이터타입[] 변수명 = new 데이터타입[개수]
//   ex) int[] arr = new int[5];

// 배열 메모리 접근
// - 문법
// - 배열변수[인덱스] = 값;
// ex) srr1[0] = 100;
// - 배열 인덱스는 0부터 이고, 인덱스의 범위는 0~(배열갯수-1) 이다.