<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/login.js"></script>
  
  
</head>
<body>
   <div class="container" style="width:500px; margin-top:200px;">
      <form name="loginForm" action="./login.do" method="post">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="id" type="text" class="form-control" name="id" placeholder="아이디 입력">
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="pw" type="password" class="form-control" name="pw" placeholder="비밀번호 입력">
    </div>
    <br>
    	<div id="notMember"></div>
    <br>
    <div>
      <button class="btn btn-success btn-block btn-lg">로그인</button>
      <button class="btn btn-info btn-block btn-lg">로그인_jQueryAjax</button>
      <!-- form 안의 버튼은 무조건 submit으로 동작! -->
      
    </div>
  </form>
   </div>
</body>
</html>