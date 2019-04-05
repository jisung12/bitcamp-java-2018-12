<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
  List<PhotoBoard> list = (List<PhotoBoard>) request.getAttribute("list");
  String contextRootPath = application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>사진 목록(JSP)</h1>
  <p>
    <a href='add'>사진 추가</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>등록일</th>
      <th>조회수</th>
      <th>수업 번호</th>
    </tr>
    <%
      for (PhotoBoard photoBoards : list) {
    %>
    <tr>
      <td><%=photoBoards.getNo()%></td>
      <td><a href='detail?no=<%=photoBoards.getNo()%>'><%=photoBoards.getTitle()%></a></td>
      <td><%=photoBoards.getCreatedDate()%></td>
      <td><%=photoBoards.getViewCount()%></td>
      <td><%=photoBoards.getLessonNo()%></td>
    </tr>
    <%
      }
    %>
  </table>
  
  <form action='search'>
    수업번호: <input type='number' name='lessonNo'> 검색어: <input type='text' name='searchWord'>
    <button type='submit'>검색</button>
  </form>
  <a href='<%=contextRootPath%>/index.html'>처음화면</a>
</body>
</html>




