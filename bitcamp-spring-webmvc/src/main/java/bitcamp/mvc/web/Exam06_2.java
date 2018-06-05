// 요청 핸들러의 파라미터 - 콘텐트를 직접 리턴하기 II
package bitcamp.mvc.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_2")
public class Exam06_2 {
    
    // request handler 에서 콘텐트를 직접 리턴할 때
    // HttpEntity에 담아서 리턴할 수 있다.
    @GetMapping(value="m1")
    @ResponseBody
    public HttpEntity<String> m1() {
        // 마찬가지로 응답 컨텐트의 기본 타입은 
        // "text/html;charset=ISO-8859-1" 이다.
        HttpEntity<String> entity = new HttpEntity<>(
                "Exam06_1.m1() ==> 012ABCabc#!@가각간");
        return entity;
    }
    
    @GetMapping(value="m2")
    @ResponseBody
    public HttpEntity<String> m2() {
        // 응답 콘텐트의 타입과 문자표를 지정하고 싶다면
        // 응답 헤더를 명시적으로 지정하라!
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        HttpEntity<String> entity = new HttpEntity<>(
                "Exam06_1.m1() ==> 012ABCabc#!@가각간",
                headers);
        return entity;
    }
    
}
