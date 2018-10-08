
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
body{
background-image:url("./img/227764-P1PRQH-229.JPG");
background-size: 100% ;
}
.form-control-borderless {
    border: none;
}

.form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
    border: none;
    outline: none;
    box-shadow: none;
}
</style>
</head>
<body>
<<<<<<< HEAD
	<img alt="index_image" src="img/index_image.JPG" id="index_image">
	<div align="center">
		<div id ="div1">
			<img alt="logo" src="img/logo.png" id="logo">
					
			<form action="DispatcherServlet">
				<div class="input-group mb-3">
				    <span id="home" class="btn btn-outline-secondary">
				    	<!-- home 페이지 연결 -->
			        	<a href="recipeinsert.jsp"><input type="button" id="homeBtn"></a>
			        </span>
			        
				    <input type="text" placeholder="Search..." id="myInput" name="search">
					<input type="hidden" name="command" value="search">
			        <span id="search" class="btn btn-outline-secondary">
			        	<input type="submit" value="" id="searchBtn">
			        </span>		        	
				</div>
			</form>
		</div>	
	</div>

</body>
</html>