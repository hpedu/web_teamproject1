<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
 #mainimg:hover{
  -webkit-transform:scale(1.2);
    -moz-transform:scale(1.2);
    -ms-transform:scale(1.2);   
    -o-transform:scale(1.2);
    transform:scale(1.2);
 }
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<div class="container" style="padding: 100px;">
		<!-- 메인 이미지, 레서피 상세정보 row입니다. -->
		<div class="row">
			<div class="col-sm-4">
				<!--${recipe.img_urls}에서 이미지 따와야함.-->
				<img id="mainimg" src="${rvo.imgurls}" class="rounded" alt="recipeimg"
					style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
			</div>
			<div class="col-sm-8" style="padding: 20px;">
				<H3>
					레서피 이름 : &nbsp;&nbsp;&nbsp; <b>${rvo.name}<%-- ${recipe.name} --%></b>
				</H3>
				<hr color="orange">
				<table style="width: 100%; height: 250px">
					<tr>
						<td width="100px" height="5px"><b>주 재료 :</b></td>
						<td>${rvo.main_ingredientents} <%-- ${recipe.main_ingredients} --%></td>
					</tr>
					<tr>
						<td><b>재료 :</b></td>
						<td>${rvo.sub_ingredientents} <%-- ${recipe.sub_ingredients} --%>
						</td>
					</tr>
					<tr>
						<td><b>작성자 :</b></td>
						<td>${rvo.writer} <%-- ${recipe.writer} --%></td>
					</tr>
					<tr>
						<td><b>타입 :</b></td>
						<td>${rvo.type} <%-- ${recipe.type} --%></td>
					</tr>
					<tr>
						<td><b>설명 :</b></td>
						<td>${rvo.descript } <%-- ${recipe.descript} --%></td>
					</tr>
				</table>
			</div>
		</div>
		<br>
		<br>
		
		<div style="text-align: center">
			<h4> <b>- 조리 방법 -</b> </h4>
		</div>
		
		<!-- 조리방법이 나타날 공간입니다.  -->
		<div class="" style="">
		
			<c:forEach var="list" items="${contents}" varStatus="status">
				<div>
					<table>
						<tr>
							<td>
								${status.count} .
							</td>
							<td>
								${list}
							</td>
						</tr>
						<tr>
							<td colspan="2"><img src="img/1.jpg" width="600" height="300"></td>
							<%-- ${list.img_urls} --%>
						</tr>
					</table>
				</div>
			</c:forEach> 
			<!-- 일단 틀만 잡아놓습니다. -->
			

		</div>
		
		<!-- 레시피 재료  -->
		<div style="padding-top: 80px;">
		    <div>
			<h5> <b>레시피 재료</b> </h5>
		    </div>
			<table style="margin: auto;">
			<tr><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td></tr>
			<tr><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td></tr>
			</table>
			</div>
		
		
		
		
		<!-- tip -->
		<div class="row" style="background: lightgray; margin-top: 40px;">
		<div class="col-sm-2">
		<h2 style="padding: 15px; text-align: center;"><b>Tip</b></h2>
		</div>
		<div class="col-sm-10">
		<p style="padding: 10px">시제품을 사다 먹으면 더 맛있습니다. 아래 완제품 김치찌개 상품을 구매하세요.</p><!--${recipe.tip}-->
		</div>
		</div>
		
		<!-- 레시피 관련 상품들 주재료나 재료에서 따오는?? -->
		<h6 style="margin-top: 40px"><b>레시피 상품</b></h6>
		<div class="row">
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		</div>
		
		
		<!-- 관련 레서피 -->
		
		<h6 style="margin-top: 40px"><b>관련 레서피</b></h6>
		<div class="row">
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		<div class="col-sm-3" style="text-align: center;">
		<a href="#"><img src="img/kim.jpg" width="100%" height="200px"></a>
		<h6>제품명 : 우리집김치</h6>
		<h6>가격 : 39600원</h6>
		</div>
		</div>
	

	</div>



</body>
</html>