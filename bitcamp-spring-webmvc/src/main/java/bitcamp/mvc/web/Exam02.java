// @RequestMapping - 한 클래스에 여러 개의 요청 한들러 두기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping
public class Exam02 {

    // 한 클래스에 여러 개의 요청 핸들러를 정의할 때는
    // 각각의 RequestMapping 애노테이션에 URL을 지정한다.
    @RequestMapping("/exam02/m1")
    @ResponseBody 
    public String m1() {
        return "Exam02/m1() 실행!";
    }

    @RequestMapping("/exam02/m2")
    @ResponseBody 
    public String m2() {
        return "Exam02/m2() 실행!";
    }
}
