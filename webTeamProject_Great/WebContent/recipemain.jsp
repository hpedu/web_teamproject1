<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>main페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">

	/* 검색창 top에서 부터 얼마나 떨어지는가 */
	#div1 {
		z-index: 1;
		position: relative;
		margin: 50px auto 50px auto;
		
		/* form 가운데 정렬 */
		display: inline-block;
        text-align: center;
	}
	/* logo와 검색창 사이 간격 */
	#logo {
		width: 80px;
		height: 40px;
	}

	/* 검색창 css */
	#myInput {
	    width: 500px;
	    height: 46px;
	    font-size: 16px;
	    padding: 10px 20px 10px 10px;
	    border: 1px solid #ddd;
	}
	/* 검색창 클릭시 css */
	#myInput:focus {outline: 2px solid #ddd;}
		
	/* search 이미지 css */
	#search {
		width : 47px;
		height : 45px;
		padding : 0px;
		border: 0px;
	}	
	#searchBtn {
	    background-color: #FFF; 
	    color: white;
	    border: none;
	    /* border-left: 2px solid #ddd; */
	    cursor: pointer;
	    
	    width:47px;
	    height:46px;
	    background-image: url('img/searchIcon.PNG');
		background-position: 8px 7px;
	    background-size: 30px;
	    background-repeat: no-repeat;
	}
	
	#recipe_ad {
		margin: 0px auto 50px auto;
	}
	#main_div1 {
		margin: 0px auto 30px auto;
		height: 250px;
	}
	#main_div2 {
		margin: 0px auto 50px auto;
		height: 250px;
	}
	#main_div3 {
		margin: 0px auto 50px auto;
		height: 250px;
	}
	#main_div1_div1{
		width:1024px;
	}
	
	#main_div2_div1{
		width:1024px;
	}
	#main_div3_div1{
		width:1024px;
	}
	#board {
		float:left;
		width:30%;
	}
	#board2 {
		float:left;
		width:30%;
	}
	#inMenu추천 {
		float:left;
		width:40%;
	}
	#hotMenu {
		float:right;
		width: 65%;
	}
	#hotMenu1 {
		float:right;
		width: 65%;
	}
	#hotMenu2 {
		float:right;
		width: 55%;
		border-left : 1px solid;
		padding-left: 30px;
	}
	.hotMenu1{
		width:100%;
		float:right;
	}
	
	#inMenu1{
		width:100%;
		float:right;
		padding-left : 30px;
	}
	
	#inMenu2{
		width:100%;
		float:right;
		padding-left : 30px;
	}
	.hotMenu2 {
		width: 150px;
		height: 130px;
		float:left;
		margin-right: 10px;
	}
	.hotMenu2 img{
		width: 150px;
		height: 130px;
		
	}

	#ingredient_ad{
		margin: 0px auto 50px auto;
	}
	ul.ultable{ 
		display: table; 
		clear: both;
		width: 300px;

		margin-bottom: 20px;
		border-spacing: 0;
		border-collapse: collapse;
		box-sizing: border-box;
		background-color: transparent;
		list-style: none;
		padding:0;
	}

	ul.ultable li ul {
		display: table; 
		clear: both;
		width: 300px;

		list-style: none;
		padding:0;
	}

	ul.ultable li ul li {	
		display:inline-block;		
		text-align: left;	
		display: table-cell;
		padding: 8px;
		line-height: 1.42857143;
	}

	ul.ultable li:first-child ul li { 
	    font-weight: bold;
	    border-bottom-width: 1px;
	    border-top: 0;
	    vertical-align: bottom;
	   
	}
	ul.ultable-striped li ul:nth-child(2n) { background-color: #f9f9f9; }
	ul.ultable-bordered { border: 1px solid #ddd; }
	ul.ultable-bordered li ul li { border: 1px solid #ddd; }
	ul.ultable-hover li:last-child ul:hover { background-color: #f5f5f5}

</style>

</head>
<body>

<c:import url="header.jsp"/>
	<div align="center">
		<div id ="div1">
			<!-- text값 가지고 -->
			<form action="DispatcherServlet">
				<div class="input-group mb-3">
				    <span>
				    	<img alt="" src="img/cap.PNG" width="45px">
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
	
	<div id="recipe_ad" align="center">
		<img alt="" src="img/main_2.PNG" width="1024px" height="500px">
	</div>
	
	<div id="main_div1" align="center">
		<div id="main_div1_div1" align="center">
			<div id="board">
				<div class="table-responsive">          
					<table class="table">
						<thead>
							<tr>
								<th>공지사항</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>이것은 공지사항1</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항2sffe</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항3</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항44444444444444</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항5555</td>
								<td>날짜</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			<div id="hotMenu">
				<h3 align="left">오늘의 추천메뉴</h3><br>
				<div class="hotMenu1">
					<div class="hotMenu2">
						<img alt="" src="img/product_main/0000007175432_i1_1200.jpg"><br><br>
						<p>이름 : 감자탕</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/product_main/0000007175432_i1_1200.jpg"><br><br>
						<p>이름 : 김치찌개</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/product_main/0000007175432_i1_1200.jpg"><br><br>
						<p>이름 : 부대찌개</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/product_main/0000007175432_i1_1200.jpg"><br><br>
						<p>이름 : 냉동딸기</p>
					</div>
				</div>
			</div>
		</div>
	
	</div>
	<div id="main_div2" align="center">
		<div id="main_div2_div1" align="center">
			<div id="board2">
				<div class="table-responsive">          
					<table class="table">
						<thead>
							<tr>
								<th>공지사항</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>이것은 공지사항1</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항2sffe</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항3</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항44444444444444</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td>이것은 공지사항5555</td>
								<td>날짜</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			<div id="hotMenu1">
				<h3 align="left">HOT 메뉴</h3><br>
				<div class="hotMenu1">
					<div class="hotMenu2">
						<img alt="" src="img/recipe_main/KakaoTalk_20181001_102059583.jpg"><br><br>
						<p>이름 : 감자탕</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/recipe_main/KakaoTalk_20181001_102059583.jpg"><br><br>
						<p>이름 : 김치찌개</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/recipe_main/KakaoTalk_20181001_102059583.jpg"><br><br>
						<p>이름 : 부대찌개</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/recipe_main/KakaoTalk_20181001_102059583.jpg"><br><br>
						<p>이름 : 냉동딸기</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	
	<div id="ingredient_ad" align="center">
		<img alt="" src="img/main_2.PNG" width="1024px" height="500px">
	</div>
	
	<div id="main_div3" align="center">
		<div id="main_div3_div1" align="center">
			<div id="inMenu추천">
				<h3 align="left">추천 상품</h3><br>
				<div id="inMenu2">
					<div class="hotMenu2">
						<img alt="" src="img/c1.PNG"><br><br>
						<p>이름 : 천연사이다</p>
						<p>가격 : 1500원</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/c2.PNG"><br><br>
						<p>이름 : 냉동딸기</p>
						<p>가격 : 9000원</p>
					</div>

				</div>
			</div>
			
			<div id="hotMenu2">
				<h3 align="left">HOT 상품</h3><br>
				<div id="inMenu1">
					<div class="hotMenu2">
						<img alt="" src="img/c1.PNG"><br><br>
						<p>이름 : 천연사이다</p>
						<p>가격 : 1500원</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/c2.PNG"><br><br>
						<p>이름 : 냉동딸기</p>
						<p>가격 : 9000원</p>
					</div>

					<div class="hotMenu2">
						<img alt="" src="img/참깨흑임자.jpg"><br><br>
						<p>이름 : 참깨흑임자</p>
						<p>가격 : 2600원</p>
					</div>

				</div>
			</div>

		</div>
	</div>
	
	<div style="height: 200px; background-color: #ccc">
	이곳은 제일 밑
	</div>
	
</body>
</html>
