// 요청 핸들러
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c01_1")
public class Controller01_1 {

  @GetMapping("h1") 
  public String handler1() {
    return "c01_1/h1";
  }
  
  @GetMapping("h2") 
  public void handler2() {
  }
}

















