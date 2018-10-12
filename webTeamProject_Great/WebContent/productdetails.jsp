<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<style type="text/css">

	.row { 
	margin: 60px;  
	padding: 0; 
	}
	
	.menu { 
	margin: 60px;  
	padding: 0; 
	}
	
</style>
</head>
<body>

<c:import url="header.jsp"></c:import>
<div class="container">
<div class="row">
        <div class="col-sm-4">
           <img src="./img/recipe_main/KakaoTalk_20181001_102058345.jpg" class="rounded" alt="상품사진"
              style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
        </div>
        <div class="col-sm-8" style="padding: 20px;">
           <H3>
              	 <b>상품명</b>  &nbsp;&nbsp;&nbsp; 전진수<%-- ${product.name} --%>
           </H3>
           <hr color="orange">
           <table style="width: 100%; height: 200px">
              <tr>
                 <td width="100px" height="5px"><b>분        류   </b></td>
                 <td>사람 <%-- ${product.type} --%></td>
              </tr>
              <tr>
                 <td><b>원산지   </b></td>
                 <td>국내산<%-- ${product.origin} --%>
                 </td>
              </tr>
              <tr>
                 <td><b>가        격   </b></td>
                 <td>100원 <%-- ${product.price} --%></td>
              </tr>
              <tr>
                 <td><b>용        량   </b></td>
                 <td>1kg <%-- ${product.sales_volume} --%></td>
              </tr>
              <tr>
                 <td><b>제조사   </b></td>
                 <td>? <%-- ${product.brand} --%></td>
              </tr>
           </table>
           <div style="text-align:right;">
           <button type="button" class="btn btn-warning" >장바구니 담기</button>&nbsp;&nbsp;&nbsp;
           <button type="button" class="btn btn-warning" >구매하기</button>
           </div>
        </div>
     </div>
     
     
         
  <div class="menu" data-spy="scroll" data-target=".navbar" data-offset="50" align="center">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark"  style="text-align: center;">  
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#section1">상세정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section2">배송정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section3">관련상품</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section4">상품문의</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section5">상품후기</a>
    </li>
  </ul>
</nav>

<div id="section1" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>상세정보</h1>
  <p>상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  상세정보<br>
  </p>
</div>
<div id="section2" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>배송정보</h1>
  <p>배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br>
  배송정보<br></p>
</div>
<div id="section3" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>관련상품</h1>
  <p>상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br>
  상품정보<br></p>
</div>
<div id="section4" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>상품문의</h1>
  <p>문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br>
  문의사항<br></p>
</div>
<div id="section5" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>상품후기</h1>
  <p>후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br>
  후기다<br></p>
</div>
</div>
</div>
</body>
</html>
