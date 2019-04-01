package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/list")
@SuppressWarnings("serial")
public class LessonListServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = InitServlet.iocContainer.getBean(LessonService.class);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    List<Lesson> lessons = lessonService.list();
    
    out.println("<html><head><title>수업 목록</title></head>");
    out.println("<body><h1>수업 목록</h1>");
    out.println("<p><a href='add'>수업 등록</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>제목</th> <th>시작일</th> <th>종료일</th> <th>총 수업시간</th> </tr>");
    
    for (Lesson lesson : lessons) {
      out.println(String.format(
          "<tr><td>%d</td> <td><a href='detail?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> <td>%d</td></tr>", 
          lesson.getNo(), 
          lesson.getTitle(), 
          lesson.getStartDate(),
          lesson.getEndDate(),
          lesson.getTotalHours()));
    }
    out.println("</table></body></html>");
  }
}
