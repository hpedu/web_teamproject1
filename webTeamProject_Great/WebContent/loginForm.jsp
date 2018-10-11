<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	body {font-family: Arial, Helvetica, sans-serif;}
	form {
		float: center;
		width: 500px;
		margin: auto;
	}
	#loginIdPw{
		width: 75%;
		margin: 0px;
		float: left;
	}
	#loginBtn{
		width: 20%;
		height: 115px;
		float: right;
		margin: 50px 0;
	}
	input[type=text], input[type=password] {
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    width: 100%;
	}
	
	button {
	    background-color: #FF9C34;
	    color: white;
	    margin: 8px 0;
	    border: none;
	    cursor: pointer;
	}
	
	button:hover {
	    opacity: 0.8;
	}
	
	.registerbtn {
	    width: auto;
	    padding: 10px 18px;
	    background-color: #ff9c34;
	}
	.cancelbtn {
	    width: auto;
	    padding: 10px 18px;
	    background-color: #f44336;
	}
	
	.imgcontainer {
	    text-align: center;
	    margin: 24px 0 12px 0;
	}
	
	.idpwcontainer {
	    padding: 20px;
	}
	
</style>

<script type="text/javascript">
	function registerGo(){
		location.href = "registerForm.jsp";
	}
	
	function mainGo(){
		location.href = "recipemain.jsp";
	}
	
</script>
</head>
<body>
	<c:import url="header.jsp"/>

	<h2>Login Form</h2>
	
	<div id="recipe_ad" align="center">
	   <img alt="" src="img/main_2.PNG" width="1024px" height="500px">
	</div>
	
	<form action="DispatcherServlet">
		<div class="imgcontainer">
			<img src="img/logo.png" alt="logo">
		</div>
		
		<div class="idpwcontainer">
			<div id="loginIdPw">
				<label for="id"><b>ID</b></label>
				<input type="text" placeholder="ID를 입력하세요..." name="id" required>
				<br>
				<label for="password"><b>Password</b></label>
				<input type="password" placeholder="비밀번호를 입력하세요..." name="password" required>
			</div>
			<input type="hidden" name="command" value="login">
			<button type="submit" id="loginBtn">Login</button>

		</div>
		<br><br><br>
		<br><br><br>
		<br><br><br>
		<div style="float: right; margin-right: 20px;">
			<button type="button" class="registerbtn" onclick="registerGo()">회원가입</button>
			<button type="button" class="cancelbtn" onclick="mainGo()">Home</button>
		</div>
	</form>
	<br><br><br>
	<br><br><br>
	<c:import url="footer.jsp"/>
	
</body>
</html>