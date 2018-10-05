<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container">
		<div>
			<br><br>
			<h1 align="center">Recipe enroll</h1><br><br>
			<h5>음식이름</h5>
			<input type="text" class="form-control" placeholder="ex)김치볶음밥"	><br><br>
		</div>	
		<div>
			<h5>음식사진 (최소 한장은 등록하셔야 합니다)</h5>
			<div class="input-group mb-3">
			<input type="file" class="form-control" placeholder="음식사진1" style="width=50%">
			<div class="input-group-append">
			<button type="button" class="btn btn-enroll">upload</button></div></div>
			<div class="input-group mb-3">
			<input type="file" class="form-control" placeholder="음식사진2" style="width=50%">
			<div class="input-group-append">
			<button type="button" class="btn btn-enroll">upload</button></div></div>
			<div class="input-group mb-3">
			<input type="file" class="form-control" placeholder="음식사진3" style="width=50%">
			<div class="input-group-append">
			<button type="button" class="btn btn-enroll">upload</button></div></div><br><br>
		</div>
	</div>
	
	<div class="container">
	<h5>음식 분류</h5>
		<select name="category">
	  		<option value="구이" selected="selected">구이</option>
	  		<option value="면류">면류</option>
	  		<option value="밥류">밥류</option>
	  		<option value="샐러드">샐러드</option>
	  		<option value="국류">국류</option>
		</select>
	</div>
	<br><br>
	<div class="container">
	<div class="row">
		<div class="col-sm-4" style="margin-right:20px;">
			<h5>주재료</h5>
			<input type="text" name="ingredient1" placeholder="주재료 1"><br><br>
			<input type="text" name="ingredient2" placeholder="주재료 2"><br><br>
			<input type="text" name="ingredient3" placeholder="주재료 3"><br><br>
		</div>
		<div  class="col-sm-4" >
			<h5>부재료</h5>
			<input type="text" name="sub_ingredient1" placeholder="부재료 1"><br><br>
			<input type="text" name="sub_ingredient2" placeholder="부재료 2"><br><br>
			<input type="text" name="sub_ingredient3" placeholder="부재료 3"><br><br>
		</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<div>
		<h5>요리방법</h5>
			<div class="form-group">
				<label for="email">1번:</label> 
				<input type="text" class="form-control" id="email" placeholder="요리방법 설명" name="email">
				<input type="file" align="left" class="form-control" id="email" placeholder="사진 업로드" name="email">
			</div>
			<div class="form-group">
				<label for="email">2번:</label> 
				<input type="text" class="form-control" id="email" placeholder="요리방법 설명" name="email">
				<input type="file" class="form-control" id="email" placeholder="사진 업로드" name="email">
			</div>
			<div class="form-group">
				<label for="email">3번:</label> 
				<input type="text" class="form-control" id="email" placeholder="요리방법 설명" name="email">
				<input type="file" class="form-control" id="email" placeholder="사진 업로드" name="email">
			</div>
		</div>
		<div>
			<h5><span class="badge badge-warning">Tip</span></h5>
			
			
			<div class="container">
			  <form action="/action_page.php">
			    <div class="form-group">
			      <label for="comment">Comment</label>
			      <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
			    </div>
			  </form>
			 <div align="right">  
			 <button type="submit" class="btn btn-default">취소하기</button>
			 <button type="submit" class="btn btn-info">등록하기</button>
			 </div>
			</div>
		</div>
	</div><br><br><br>
	<c:import url="footer.jsp"></c:import>
</body>
</html>