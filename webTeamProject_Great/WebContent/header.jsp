<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: orange">

  <!-- Brand/logo -->
  <div class="container">
  <a class="navbar-brand" href="#">
    <img src="./img/logo_white.png" alt="logo" style="width:150px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav nav-pills">
    <li class="nav-item">
      <a class="nav-link" href="#" style="color:white">레시피</a>
       
    </li>
    
    <li><a class="nav-link" href="#">|</a></li>
    
    <li class="nav-item">
      <a class="nav-link" href="#" style="color:white">나만의 레시피</a>
    </li>
    
    <li><a class="nav-link" href="#">|</a></li>
    
    <li class="nav-item">
      <a class="nav-link" href="#" style="color:white">레시피 Talk</a>
    </li>
    
    <li><a class="nav-link" href="#">|</a></li>
    
      <li class="nav-item">
      <a class="nav-link" href="#" style="color:white">SHOP</a>
    </li>
    
    <li><a class="nav-link" href="#">|</a></li>
    
      <li class="nav-item">
      <a class="nav-link" href="#" style="color:white">EVENT</a>
    </li>
  </ul>
  <div class="btn-group">
  <button type="button" class="btn dropdown-toggle" style="background-color: orange" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <img src="./img/member.png" alt="logo" style="width:20px;">
  </button>
	<div class="dropdown-menu">
    <a class="dropdown-item" href="login.jsp">로그인</a>
    <a class="dropdown-item" href="register.jsp">회원가입</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#" onclick="alert('준비중입니다.')">ID/PW 찾기</a>
  </div>
  </div>
  </div>
</nav>
 <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
 	<button class="dropdown-item" type="button">Action</button>
    <button class="dropdown-item" type="button">Another action</button>
    <button class="dropdown-item" type="button">Something else here</button>
  
</div>
</body>
</html>