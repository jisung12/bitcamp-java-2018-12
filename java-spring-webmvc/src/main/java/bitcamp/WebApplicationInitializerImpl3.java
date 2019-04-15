package bitcamp;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 서블릿 컨테이너가 시작될 때 보고 받는 객체 
// 
public class WebApplicationInitializerImpl3 extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
      return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
      XmlWebApplicationContext iocContainer = new XmlWebApplicationContext();
      iocContainer.setConfigLocation("/WEB-INF/app8-servlet.xml");
      return iocContainer;
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/app8/*" };
  }


}
