package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam01 {
    // 요청을 다루는 자 = requestHandler
    
    @RequestMapping("/exam01/m1")
    @ResponseBody // 리턴 값이 view URL 이 아니라 콘텐트임을 가리킨다.
    public String m1() {
        return "Hello!";
    }
}
