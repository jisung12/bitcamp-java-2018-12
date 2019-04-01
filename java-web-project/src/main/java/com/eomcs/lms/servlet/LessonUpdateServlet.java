package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/update")
public class LessonUpdateServlet extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = ServerApp.iocContainer.getBean(LessonService.class);

    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(request.getParameter("no")));
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startdate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("enddate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalhour")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayhour")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head>"           
        + "<title>수업 정보 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>수업 정보 변경</h1>");

    if (lessonService.update(lesson) == 0) {
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
    out.println("</body></html>");
  }
}