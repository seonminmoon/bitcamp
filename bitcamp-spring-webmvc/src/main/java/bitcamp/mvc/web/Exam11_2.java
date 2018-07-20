// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@RestController 
@RequestMapping("/exam11_2") 
public class Exam11_2 {

    @Autowired ServletContext sc;

    @PostMapping("upload01")
    public Object upload01( // 파일 한개 받기
            MultipartFile files) {
        HashMap<String, Object> jsonData = new HashMap<>();

        String filesDir = sc.getRealPath("/files");  // 진짜 Real Path (사진이 저장되는 폴더명)

        int i = 0;
        // file에 대해 original File명과 새 파일을 구분하기 위해서
        String filename = UUID.randomUUID().toString();
        jsonData.put("filename", filename);
        jsonData.put("filesize", files.getSize());
        jsonData.put("originname", files.getOriginalFilename());
        try {
            File path = new File(filesDir + "/" + filename);
            System.out.println(path);
            files.transferTo(path); // 거기에 새 파일 이름을 붙임.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    
    

    @PostMapping("upload02")
    public Object upload02( // 파일 여러개받기
            MultipartFile[] files) {
        // 여러 개 파일을 한 번에 보내기 => 추천하지 않는다.
        // 한번에 보내다가 중간에 오류나면 전체가 다 날라가기 때문에 개별로 보내는 방법을 추천함.
        String filesDir = sc.getRealPath("/files");  // 진짜 Real Path (사진이 저장되는 폴더명)

        ArrayList<Map<String,Object>> jsonDataList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            HashMap<String, Object> jsonData = new HashMap<>();
            String filename = UUID.randomUUID().toString();
            jsonData.put("filename", filename);
            jsonData.put("filesize", files[i].getSize());
            jsonData.put("originname", files[i].getOriginalFilename());
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                jsonDataList.add(jsonData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonDataList;
    }
    
    

    @PostMapping("upload03") // 파일 업로드가 핵심이라서 이름,나이만 작성하고 파일 업로드를 안하면 동작이 안됨. (upload11.html)
    public Object upload03(
            String name,
            int age,
            MultipartFile[] files) {
        String filesDir = sc.getRealPath("/files");  // 진짜 Real Path (사진이 저장되는 폴더명)

        HashMap<String,Object> returnData = new HashMap<>();
        returnData.put("name", name);
        returnData.put("age", age);
        
        ArrayList<Map<String,Object>> jsonDataList = new ArrayList<>();
        returnData.put("files", jsonDataList);
        
        for (int i = 0; i < files.length; i++) {
            HashMap<String, Object> jsonData = new HashMap<>();
            String filename = UUID.randomUUID().toString();
            jsonData.put("filename", filename);
            jsonData.put("filesize", files[i].getSize());
            jsonData.put("originname", files[i].getOriginalFilename());
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                jsonDataList.add(jsonData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }
    
    

    @PostMapping("upload04")
    public Object upload04( // 썸네일
            MultipartFile files) {
        HashMap<String, Object> jsonData = new HashMap<>();

        String filesDir = sc.getRealPath("/files");  // 진짜 Real Path (사진이 저장되는 폴더명)

        int i = 0;
        // file에 대해 original File명과 새 파일을 구분하기 위해서
        String filename = UUID.randomUUID().toString();
        jsonData.put("filename", filename);
        jsonData.put("filesize", files.getSize());
        jsonData.put("originname", files.getOriginalFilename());
        try {
            File path = new File(filesDir + "/" + filename);
            files.transferTo(path); //파일 저장하기
            
            // 썸네일 이미지 생성
            
            Thumbnails.of(path)
                        .size(50, 50)
                        .outputFormat("jpg")
                        .toFile(path.getCanonicalFile() + "_50x50");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    

    
    
}






