// 배열
package step02;

public class Exam09_2 {
    public static void main(String[] args){
        int arr1[] = new int[5]; // ok! C-style

        arr1[0] = 0;
        arr1[1] = 0;
        arr1[2] = 0;
        arr1[3] = 0;
        arr1[4] = 0;

        // 배열 선언과 초기화를 한 번에 하기
        // int arr[4] = new int[4] {0,0,0,0};


        // int arr[] = new int[5] {0, 0, 0, 0, 0} 

        int arr2[] = new int[]{0,0,0,0};
        int [] arr3;
        arr3 = new int[] {0,0,0,0}

        // 1) 배열 선언 + 초기화 명령
        int arr2[] = new int[]{0, 0, 0, 0};
        int arr3[] = {0, 0, 0, 0};

        // 2) 배열 선언 ==> 초기화 명령
        int[] arr4;
        arr4 = new int[]{0, 0, 0, 0};

        int[] arr5;
        // 배열 변수를 선언 후 따로 초기화 시킬 경우,
        // new 명령을 생략할 수 없다.
        arr5 = {0,0,0,0}; // 컴파일 오류!
    }
}


배열 문법 강ㅇ사님꺼보고
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