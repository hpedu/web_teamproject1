<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style type="text/css">
.slider {
   width: 50%;
   margin: 100px auto;
}
.slick-slide {
   margin: 0px 20px;
}
.slick-slide img {
   width: 100%;
}
.slick-prev:before, .slick-next:before {
   color: black;
}
.slick-current {
   opacity: 1;
}
table {
   
}
h1 {
   display: block;
   width: 1200px;
   text-align: left;
   clear: both;
   margin: auto;
}
#cartbtn {
   background-color: white;
   color: orange;
   padding: 10px 10px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   border-radius: 10px;
}
#cartbtn:hover {
   background-color: orange;
   color: white;
}
</style>
</head>
<body>
   <c:import url="header.jsp"></c:import>
   <h1>
      <font color="black" size="15"><i
         class="glyphicon glyphicon-shopping-cart"></i> 장바구니</font>
   </h1>
   <c:choose>
      <c:when test="${cartSize==0}">
         <!-- 장바구니가 비었다면 -->
         <h1 align="center">
            <font color="red">Cart에 담겨진 물건이 없습니다.</font>
         </h1>
      </c:when>
      <c:otherwise>
         <div class="cart">
            <form action="DispatcherServlet" method="get" name="frm" id="frm">
            <input type="hidden" name="command" value="ItemCartD">
            
               <table width="1200" align="center" border="1">
                  <tr align="center" bgcolor="orange">
                     <td>번호</td>
                     <td>상품이미지</td>
                     <td>상품명</td>
                     <td>상품가격</td>
                     <td>수량</td>
                     <td align="center"><input type="submit" value="삭제">
                     </td>
                  </tr>
                  <c:forEach var="cartList" items="${cartList}" varStatus="i">
                     <tr align="center">
                        <td>${i.count}</td>
                        <td><img src="${cartList.img_urls}" alt="" width="70"
                           height="70"></td>
                        <td>${cartList.name}</td>
                        <td>${cartList.price}</td>
                        <td><a href="DispatcherServlet?command=itemCartQtyUp&&name=${cartList.name}"><img
                              alt="1증가" src="img/up.jpg" width="15" height="15" border="0"></a><br>
                           ${cartList.quantity}<br> <a
                           href="javascript:checkQty('${cartList.name}',${cartList.quantity})"><img
                              alt="1감소" src="img/down.jpg" width="15" height="15" border="0"></a>
                        </td>
                        <td align="center"><input type="checkbox" name="delete"
                           value="${cartList.name}"></td>
                     </tr>
                  </c:forEach>
               </table>
            </form>
         </div>
         <table width="1200" align="center" border="0">
            <tr align="center" bgcolor="orange">
               <td align="right"><font size="5" color="gray">총 결제금액 : ${sumMoney}</font></td>
            </tr>
         </table>
      </c:otherwise>
   </c:choose>
   <p>
      <br> <br> <br>
   </p>
   <table width="600" align="center">
      <tr>
         <td><h2>
               <a href="index.jsp" id="cartbtn">쇼핑 계속하기</a>
            </h2></td>
         <td><h2>
               <a href="#" id="cartbtn">구매하기</a>
            </h2></td>
      </tr>
   </table>
   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
  <h1 class="title">HOT 추천</h1>
        <div class="slider lazy" role="toolbar">
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>밥밥밥</a></div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>김김김</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>김치치치</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>메밀면</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>소면면</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="./img/recipe_main/rice/bab.jpg"/>/>우동면면</div>           
        </div>
   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
   <c:import url="footer.jsp"></c:import>
</body>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"
   type="text/javascript"></script>
<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(document).on('ready', function() {
     
      $('.lazy').slick({
         lazyLoad: 'ondemand',
         slidesToShow: 5,
         slidesToScroll: 1
      });
    }); 
    
    function checkQty(name, qty) {
		if(qty!=1)
			location.href="DispatcherServlet?command=itemCartQtyDown&&name="+name;
		else
			return;
	}
</script>
</html>