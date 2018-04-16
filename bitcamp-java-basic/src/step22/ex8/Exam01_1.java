package step22.ex8;

import java.io.FileOutputStream;

public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test8.data");
        DataOutputStream out = new DataOutputStream(fileOut);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;

        // 장신구/보조장치/플러그인(decorator)를 사용하여 String,int,boolean 값을 출력한다.
        long startTime = System.currentTimeMillis(); // 밀리초
        for (int i = 0; i<100000; i++) {
            out.writeUTF(member.name); 
            out.writeInt(member.age);
            out.writeBoolean(member.gender);
            }
        long endTime = System.currentTimeMillis(); // 밀리초
        
        System.out.println(endTime - startTime);
        out.close();

        System.out.println("데이터 출력 완료!");

    }

}
