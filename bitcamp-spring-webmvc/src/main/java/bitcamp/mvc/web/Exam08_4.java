// 세션 다루기 - HttpSession 데이터 꺼내기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/exam08_4")
@SessionAttributes({"name","age","working"})
// 세션의 값을 @ModelAttribute를 사용하여 꺼내려면
// 마찬가지로 @SessionAttributes 애노테이션을 사용하여 꺼낼 값의 이름을 지정해야 한다.
public class Exam08_4 {
    // Model 에 저장하는건 세션하고 전혀 상관이 없다. ServletRequest에 저장되기 때문이다.
    // 그런데 @SessionAttribute 가 붙게 되면 HttpSession 에도 저장이 된다.
    // 결론적으로 ServletRequest + HttpSession 둘 다 저장된다.
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            // 만약 세션에 보관된 값이 없다면 실행 오류가 발생한다!
            @ModelAttribute("name") String name,
            @ModelAttribute("age") int age,
            @ModelAttribute("working") boolean working) {
        
        // @ModelAttribute로 세션에 보관된 값을 꺼내기
        return String.format("m1(): @ModelAttribute로 세션 값 꺼내기 - name=%s, age=%d, working=%b",
                name, age, working);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(SessionStatus status) {
        // 세션에 보관된 데이터는 status로 값이 안날라 갈 때가 있다.
        // 그럴때는 session.invalidate() 로 직접 값을 날리면 된다.
        
        // SessionStatus로 세션에 보관된 값 없애기
        status.setComplete(); // 세션을 종료하겠다
        return String.format("m2(): SessionStatus로 세션에 보관된 값 없애기");
    }
}
