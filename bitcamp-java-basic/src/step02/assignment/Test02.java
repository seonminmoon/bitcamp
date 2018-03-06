
package step02.assignment;

//6단계 : 형식을 갖춘 문자열 출력하기
public class Test02 {
    public static void main(String[] args){

        String[] name = new String[5];
        int[] kor = new int[5];
        int[] eng = new int[5];
        int[] math = new int[5];
        int[] sum = new int[5];
        float[] avg = new float[5];

        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

     
        for(int i=0; i<3; i++) {
            System.out.print("입력? ");
            name[i] = keyScan.next();
            kor[i] = keyScan.nextInt();
            eng[i] = keyScan.nextInt();
            math[i] = keyScan.nextInt();
            sum[i] = kor[i]+eng[i]+math[i];
            avg[i] = sum[i]/3;
        }

        System.out.println("========================");
        for(int i=0; i<3; i++){
        System.out.printf("%s %d %d %d %d %.2f \n",name[i], kor[i], eng[i], math[i], sum[i], avg[i]);
        }

    }
}

