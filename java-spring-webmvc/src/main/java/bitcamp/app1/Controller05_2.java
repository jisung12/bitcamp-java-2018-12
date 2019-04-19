// 요청 핸들러의 아규먼트 - 프론트 컨트롤러로부터 받을 수 있는 파라미터 값
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.JstlView;

@Controller 
@RequestMapping("/c05_2")
public class Controller05_2 {

  @GetMapping("h1") 
  public String handler1() {
    return "/jsp/c05_2.jsp";
  }

  @GetMapping("h2") 
  public String handler2() {
    return "/WEB-INF/jsp/c05_2.jsp";
  }

  @GetMapping("h3") 
  public JstlView handler3() {
    return new JstlView("/WEB-INF/jsp/c05_2.jsp");
  }

  @GetMapping("h4") 
  public ModelAndView handler4() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/WEB-INF/jsp/c05_2.jsp");
    return mv;
  }
  
  @GetMapping("h5") 
  public String handler5() {
    return "redirect:h4";
  }
  
  @GetMapping("h6") 
  public String handler6() {
    return "forward:h4";
  }

}





