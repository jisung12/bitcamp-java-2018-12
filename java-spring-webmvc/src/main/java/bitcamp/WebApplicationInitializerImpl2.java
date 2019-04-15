package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 서블릿 컨테이너가 시작될 때 보고 받는 객체 
// 
public class WebApplicationInitializerImpl2 extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {

    return new Class<?>[] { AppConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // Spring IoC 컨테이너의 설정 정보를 갖고 있는 Java Config 클래스를 리턴한다.
    return new Class<?>[] { AppConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    // 스프링 프레임워크에서 DispatcherServlet을 등록할 때 이 메서드를 호출한다.
    // 이 메서드의 리턴 값을 가지고 URL 패턴을 지정한다.
    return new String[] { "/app7/*" };
  }
  
  @Override
  protected String getServletName() {
    // Spring Web MVC 프레임워크는 
    // 웹 애플리케이션에 DispatcherServlet을 등록할 때 이 메서드를 호출한다. 
    // 이 메서드의 리턴 값이 서블릿의 이름으로 사용된다. 
    // 이 메서드를 오버라이딩 하지 않으면 기본 이름("dispatcher")이 사용된다.
    // 
    return "app7";
  }
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // 이 메서드가 호출될 때 간단한 메세지를 출력하기 위해 오버라이딩 하였다.
    // 따라서 원래의 메서드를 반드시 호출해줘야 한다.
    System.out.println("WebApplicationInitializerImpl2.onStartup() ... 호출됨");
    super.onStartup(servletContext);
  }

}
