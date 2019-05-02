<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
<jsp:include page="../commonCss.jsp"/>
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="container">
  <h1>새 회원</h1>
  <form action='add' method='post' enctype='multipart/form-data'>


      <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-8">
        <textarea class="form-control" id="name" 
                name='name' rows='1'>${member.name}</textarea>
      </div>
     </div>
     
     <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-4">
      <input type="email" placeholder="이메일 입력"  
              name='email' class="form-control" 
          id="email">${member.email}
    </div>
  </div>
     
      
      <div class="form-group row">
       <label for="password" class="col-sm-2 col-form-label">암호</label>
      <div class="col-sm-4">
        <input type="password" name='password'  class="form-control" 
           placeholder="비밀번호"  id="password">${member.password}
      </div>
    </div>
     
      
       <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">사진</label>
        <div class="col-sm-8">
        <td><input type='file' name='photoFile'></td>
       </div>
      </div>
      
      <div class="form-group row">
        <label for="tel" class="col-sm-2 col-form-label">전화</label>
        <div class="col-sm-8">
        <textarea class="form-control" id="tel" 
                name='tel' rows='1'>${member.tel}</textarea>
      </div>
     </div>
      
    <div class="form-group row">
    <div class="col-sm-10">
      <button class="btn btn-primary">등록</button>
      <a class="btn btn-primary" href='.'>목록</a> 
    </div>
  </div>
  </form>
</body>
</div><!-- .container -->

<jsp:include page="../javascript.jsp"/>
</html>





