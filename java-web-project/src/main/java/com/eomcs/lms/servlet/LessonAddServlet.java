package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/add")
@SuppressWarnings("serial")
public class LessonAddServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>수업 등록</title></head>");
    out.println("<body>");
    out.println("<h1>수업 등록</h1>");
    out.println("<form action='add' method='post'>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>수업명</th>");
    out.println("  <td><input type='text' name='title'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>설명</th>");
    out.println("  <td><input type='text' name='contents'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>시작일</th>");
    out.println("  <td><input type='date' name='startdate'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>종료일</th>");
    out.println("  <td><input type='date' name='enddate'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>총수업시간</th>");
    out.println("  <td><input type='number' name='totalhour'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>일수업시간</th>");
    out.println("  <td><input type='number' name='dayhour'></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    LessonService lessonService = InitServlet.iocContainer.getBean(LessonService.class);
    
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startdate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("enddate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalhour")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayhour")));
    
    lessonService.add(lesson);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html><head>"           
        + "<title>수업 정보 등록</title>"
        + "<meta http-equiv='Refresh' content='0.1;url=list'>"
        + "</head>");
    out.println("<body><h1>수업 정보 등록</h1>");
    out.println("<p>저장하였습니다.</p>");
    out.println("</body></html>");
  }
}
