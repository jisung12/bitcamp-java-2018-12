package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

// 서블릿 컨테이너가 시작될 때 보고 받는 객체 
// 
public class WebApplicationInitializerImpl1 implements WebApplicationInitializer {
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebApplicationInitializerImpl1.onStartup()... 호출됨");
    
  }
}
