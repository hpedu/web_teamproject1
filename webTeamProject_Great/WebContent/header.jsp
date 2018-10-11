<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
   .navbar{
      padding: 10px 15px 15px 15px;
   }
   li{
    	list-style-type: none;
   }
</style>
</head>
<body>
   <nav class="navbar navbar-inverse" style="background-color: orange; border:0px solid orange">

      <!-- Brand/logo -->
      <div class="container">
      <div class="row" style="margin:auto">
      <div class="col-sm-2">
         <a class="navbar-brand" href="#" style="padding:0px">
            <img src="./img/logo_white.png" alt="logo" style="height:100%;">
         </a>
  	</div>
  	<div class="col-sm-8">
         <!-- Links -->
         <ul class="nav navbar-nav">
            <li class="nav-item">
               <a class="nav-link" href="DispatcherServlet?command=search" style="color:white">레시피</a>
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
         </div>
         <div class="col-sm-2" style="height:50px">
         <div class="btn-group" >
            <button type="button" class="btn dropdown-toggle" style="background-color: orange;    padding: 10px;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               <img src="./img/member.png" alt="logo" style="width:20px;">
            </button>
            <c:choose>
               <c:when test="${login != null}">
                  <div class="dropdown-menu">
                     <a class="dropdown-item" href="#">장바구니</a>
                     <a class="dropdown-item" href="DispatcherServlet?command=logout">로그아웃</a>
                     
                  </div>
               </c:when>
               <c:otherwise>
                  <div class="dropdown-menu">
                     <a class="dropdown-item" href="loginForm.jsp">로그인</a>
                     <a class="dropdown-item" href="registerForm.jsp">회원가입</a>
                     <div class="dropdown-divider"></div>
                     <a class="dropdown-item" href="#" onclick="alert('준비중입니다.')">ID/PW 찾기</a>
                  </div>
               </c:otherwise>
            </c:choose>
         </div>
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