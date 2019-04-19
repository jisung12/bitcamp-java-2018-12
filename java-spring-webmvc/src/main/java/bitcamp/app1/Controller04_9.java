// 요청 핸들러의 아규먼트 - multipart/form-data 형식의 파라미터 값 받기
package bitcamp.app1;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_9")
public class Controller04_9 {

  // 클라이언트가 멀티파트 형식으로 전송한 데이터를 꺼내기
  // => MultipartFile 타입의 아규먼트를 선언하면 된다.
  
  // 테스트:
  //    http://.../html/app1/c04_9.html
  @PostMapping(value="h1", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public String handler1(
      String name,
      int age,
      @RequestBody String data
      ) throws Exception {
    
    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    out.println("<html><head><title>c04_9/h1</title></head><body>");
    out.println("<h1>결과</h1>");
    out.printf("<p>이름:%s</p>\n", name);
    out.printf("<p>나이:%s</p>\n", age);
    out.printf("<p>통데이터:%s</p>\n", data);
    out.println("</body></html>");
    return out0.toString();
  }

}










