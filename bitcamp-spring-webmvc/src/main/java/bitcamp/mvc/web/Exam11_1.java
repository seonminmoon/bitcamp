// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller 
@RequestMapping("/exam11_1")
public class Exam11_1 {

    @Autowired ServletContext sc;
    
    @PostMapping("upload01")
    public void upload01(String name, int age, MultipartFile[] files, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
        String filesDir = sc.getRealPath("/files");
        
        int i = 0;
        for(MultipartFile file : files) {
            String filename = UUID.randomUUID().toString();
            model.addAttribute("file" + i + "Original", file.getOriginalFilename());
            // original로 하면 문제점이 다른사람이 업로드한 파일까지도 똑같은 이름으로 덮어쓴다 -> 랜덤파일명을 써야함!
            model.addAttribute("file" + i + "New", filename);
            i++;
            try {
                File path =new File(filesDir + "/" + filename);
                System.out.println(path);
                file.transferTo(path);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    
    }
}
