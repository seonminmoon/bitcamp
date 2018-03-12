// 증감 연산자 : 후위(post-fix) 증감 연산자 응용 II

package step04;

public class Exam06_4 {
    public static void main(String[] args){
        int i = 2;
        int result = i++ + i++ * i++;
        // int result = 2 + 3 * 4;
        // int i = 5

        // 연산자 우선순위:
        // 1) ++, --
        // 2) *,/,%
        // 3) +,-
        // 4) =
        System.out.printf("%d, %d \n",i,result); 
    }
}
