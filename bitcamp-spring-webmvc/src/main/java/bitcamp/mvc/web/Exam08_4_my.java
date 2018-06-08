// 세션 다루기 - HttpSession 데이터 꺼내기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller 
@RequestMapping("/exam08_4_my")
@SessionAttributes({"name","age"})
// 세션의 값을 @ModelAttribute를 사용하여 꺼내려면
// 마찬가지로 @SessionAttributes 애노테이션을 사용하여 꺼낼 값의 이름을 지정해야 한다.
public class Exam08_4_my {
    // Model 에 저장하는건 세션하고 전혀 상관이 없다. ServletRequest에 저장되기 때문이다.
    // 그런데 @SessionAttribute 가 붙게 되면 HttpSession 에도 저장이 된다.
    // 결론적으로 ServletRequest + HttpSession 둘 다 저장된다.
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            @ModelAttribute("name") String name,
            @ModelAttribute("age") int age) {
        
        // @ModelAttribute로 세션에 보관된 값을 꺼내기
        return String.format("m4(): name=%s, age=%d",
                name, age);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) {
        // 세션을 무효화 하기
        session.invalidate();
        return String.format("m2(): 세션 무효화시킴!");
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(
            // SessionAttributes에 지정된 값을 꺼낼 때는 @ModelAttribute를 사용하라!
            @ModelAttribute("name") String name,
            @ModelAttribute(name="age") int age,
            @RequestParam(defaultValue="false") boolean working) {
        // @ModelAttribute(name="working") boolean working 으로 하면
        // 오류 발생!
        // 왜냐하면, 상단에 @SessionAttributes({"name","age"}) 이렇게  
        // name, age 만 꺼낼 수 있도록 값을 지정했기 때문에 
        // 값으로 지정되지 않은 데이터를 꺼내려고 하면 오류가 발생한다.
        //
        // @ModelAttribute : Spring이 관리하고있는 데이터를 꺼내라
        // @RequestParam   : 클라이언트가 보낸 데이터를 꺼내라
        
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m3(): name=%s, age=%d, working=%b",
                name, age, working);
    }
    
}
