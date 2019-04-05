package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    MemberService memberService = iocContainer.getBean(MemberService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);

    response.setContentType("text/html;charset=UTF-8");

    // JSP가 사용할 수 있도록 ServletRequest 보관소에 저장해둔다.
    request.setAttribute("member", member);

    // JSP의 실행을 포함시킨다.
    request.getRequestDispatcher("/member/detail.jsp").include(request, response);
  }
}
