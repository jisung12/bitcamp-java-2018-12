package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/list")
public class PhotoBoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    PhotoBoardService photoBoardService = iocContainer.getBean(PhotoBoardService.class);
    List<PhotoBoard> photoBoards = photoBoardService.list(0, null);
    
 // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", photoBoards);
    
    response.setContentType("text/html;charset=UTF-8");
    
 // JSP의 실행을 포함시킨다.
    RequestDispatcher rd = request.getRequestDispatcher("/photoboard/list.jsp");
    rd.include(request, response);
  }
}