<%@page import="com.eomcs.lms.domain.PhotoFile"%>
<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
  PhotoBoard photoBoard = (PhotoBoard) request.getAttribute("photoboard");
  Lesson lesson = (Lesson) request.getAttribute("lesson");
  PhotoFile photoFile = (PhotoFile) request.getAttribute("photofile");
%>
<!DOCTYPE html>

<html>
<head>
<title>사진 조회</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>사진 조회(JSP)</h1>

  <%
    if (photoBoard == null) {
  %>
  <p>해당 게시물이 없습니다....</p>
  <%
    } else {
  %>
  <form action='update' method='post'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input name='no' value='<%=photoBoard.getNo()%>' readonly></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input name='title' value='<%=photoBoard.getTitle()%>'></td>
      </tr>
      <tr>
        <th>등록일</th>
        <td><%=photoBoard.getCreatedDate()%></td>
      </tr>
      <tr>
        <th>조회수</th>
        <td><%=photoBoard.getViewCount()%></td>
      </tr>
      <tr>
        <th>수업</th>
        <td><select name='lessonNo'>
            <option value='<%=photoBoard.getLessonNo()%>'><%=photoBoard.getTitle()%>(<%=lesson.getStartDate()%> ~ <%=lesson.getEndDate()%>)</option>
        </select></td>
      </tr>
      <tr>
        <td colspan='2'>최소 한 개의 사진 파일을 등록해야 합니다.</td>
      </tr>
      <tr>
        <th>사진1</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진2</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진3</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진4</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진5</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><img src='../upload/photoboard/<%=photoFile.getFilePath() %>' style='height: 80px'> 
      </tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=<%=photoBoard.getNo()%>'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
  <%
    }
  %>
</body>
</html>



