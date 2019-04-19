// 요청 핸들러의 아규먼트 - 프론트 컨트롤러로부터 받을 수 있는 파라미터 값
package bitcamp.app1;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {

  @GetMapping("h1") 
  @ResponseBody 
  public String handler1() {
    return "<html><body><h1>abc가각간</h1></body></html>";
    
  }
  
  @GetMapping(value="h2", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public String handler2() {
    return "<html><body><h1>abc가각간</h1></body></html>";
    
  }
  
  @GetMapping("h3") 
  @ResponseBody 
  public String handler3(HttpServletResponse response) {
    response.setContentType("text/html;charset=UTF-8");
    return "<html><body><h1>abc가각간</h1></body></html>";
  }
  
  @GetMapping("h4") 
  public HttpEntity<String> handler4(HttpServletResponse response) {
    HttpEntity<String> entity = new HttpEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>");
    
    return entity;
  }
  
  @GetMapping(value="h5", produces="text/html;charset=UTF-8") 
  public HttpEntity<String> handler5(HttpServletResponse response) {
    HttpEntity<String> entity = new HttpEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>");
    
    return entity;
  }
  
  @GetMapping(value="h6", produces="text/html;charset=UTF-8") 
  public HttpEntity<String> handler6(HttpServletResponse response) {
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    HttpEntity<String> entity = new HttpEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>",
        headers);
    
    return entity;
  }
  
  @GetMapping(value="h7", produces="text/html;charset=UTF-8") 
  public ResponseEntity<String> handler7(HttpServletResponse response) {
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    headers.add("BIT-OK", "ohora");
    
    ResponseEntity<String> entity = new ResponseEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>",
        headers,
        HttpStatus.OK
        );
    
    return entity;
  }
}





