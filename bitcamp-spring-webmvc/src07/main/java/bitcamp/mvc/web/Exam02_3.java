// 페이지 컨트롤러에 의존 객체 주입하기
package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

@Controller 
@RequestMapping("/exam02_3")
public class Exam02_3 {

    @Autowired BoardDao boardDao;
    // ServletContext를 주입 받을 때도 인스턴스 변수로 주입받는다.
    @Autowired ServletContext servletContext;
    
    @RequestMapping("m1")
    @ResponseBody 
    public String m1() {
        return this.servletContext.getContextPath();
    }
}
