package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 서블릿 컨테이너가 시작될 때 보고 받는 객체 
// 
public class WebApplicationInitializerImpl1 implements WebApplicationInitializer {
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebApplicationInitializerImpl1.onStartup()... 호출됨");
    
    // DispatcherServlet에서 사용할 스프링 IoC 컨테이너를 준비한다.
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.refresh();
    
    // DispatcherServlet 인스턴스를 생성한다.
    DispatcherServlet servlet = new DispatcherServlet(ac);
    
    // 웹 애플리케이션에 DispatcherServlet을 등록한다.
    Dynamic registration = servletContext.addServlet("app6", servlet);
    
    // 웹 애플리케이션에 등록된 DispatcherServlet을 설정한다.
    registration.setLoadOnStartup(1);
    
    // DispatcherServlet에 URL 패턴을 지정한다
    registration.addMapping("/app6/*");
  }
}
