<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


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
            <img src="${product.img_urls}" 
               class="rounded" alt="��ǰ����"
               style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
         </div>
         <div class="col-sm-8" style="padding: 20px;">
            <H3>
               <b>��ǰ��</b> &nbsp;&nbsp;&nbsp;
                ${product.name}
            </H3>
            <hr color="orange">
            <table style="width: 100%; height: 200px">
               <tr>
                  <td width="100px" height="5px"><b>�� �� </b></td>
                  <td>${product.type}</td>
               </tr>
               <tr>
                  <td><b>������ </b></td>
                  <td>${product.origin}
                  </td>
               </tr>
               <tr>
                  <td><b>�� �� </b></td>
                  <td>${product.price}</td>
               </tr>
               <tr>
                  <td><b>�� �� </b></td>
                  <td>${product.amount}</td>
               </tr>
               <tr>
                  <td><b>������ </b></td>
                  <td>${product.brand}</td>
               </tr>
            </table>
            <div style="text-align: right;">
               <button type="button" class="btn btn-warning">��ٱ��� ���</button>
               &nbsp;&nbsp;&nbsp;
               <button type="button" class="btn btn-warning">�����ϱ�</button>
            </div>
         </div>
      </div>



      <div class="menu" data-spy="scroll" data-target=".navbar"
         data-offset="50" align="center">
         <nav class="navbar navbar-inverse">
              <div class="container-fluid">
            <ul class="nav navbar-nav">
               <li class="nav-item"><a class="nav-link" href="#section1">������</a></li>
               <li class="nav-item"><a class="nav-link" href="#section2">�������</a></li>
               <li class="nav-item"><a class="nav-link" href="#section3">���û�ǰ</a></li>
               <li class="nav-item"><a class="nav-link" href="#section4">��ǰ����</a></li>
               <li class="nav-item"><a class="nav-link" href="#section5">��ǰ�ı�</a></li>
            </ul>
            </div>
         </nav>

         <div id="section1" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>������</h1>
            <p>
               <br>
               <img src="${product.img_urls}" 
               class="rounded" alt="��ǰ����"
               style="height: 50%; width: 50%; margin: auto; border: 2px solid black"><br><br>
               
               ${product.content}
               
               
               <!-- ������<br> ������<br> ������<br> ������<br> ������<br>
               ������<br> ������<br> ������<br> ������<br> ������<br>
               ������<br> ������<br> ������<br> ������<br> ������<br>
               ������<br> ������<br> ������<br> -->
            </p>
         </div>
         <div id="section2" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>�������</h1><br><br>
            <p>
               <img src="./img/delivery_notice.jpg" 
               class="rounded" alt="��ǰ����"
               style="height: 100%; width: 100%; margin: auto; border: 2px solid white"><br><br>
            </p>
         </div>
         <div id="section3" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>���û�ǰ</h1>
        
        <table><tr>
		<c:forEach var="product" items="${plist.list}">
		<td style="padding:20px">
		<div >
			<div><a href="showProductDetail.do?name=${product.name}"><img class="recipe_img_top" src="${product.img_urls}"
								alt="recipe_image" style="width: 150px; height: 150px; padding: 1px"></a></div>
		<div	>
		<span style="color:#a0a0a0;font-size:1">${product.type }</span><br>
		<span style="font-size:1.2em">${product.name }</span><br>
		<span style="font-size:1em">${product.price}��</span><br>
		</div>
		</div>
		</td>
		</c:forEach>
		</tr>
	</table>
        
        
        
         </div>
         <div id="section4" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>��ǰ����</h1>
               <div class="form-group">
                 <label for="comment">Comment:</label>
                 <textarea class="form-control" rows="5" id="comment"></textarea>
                 <button type="submit" class="btn_reply add" data-tlarea="PCI2" data-tlord="2">����ϱ�</button>
               </div>
         </div>
         <div id="section5" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>��ǰ�ı�</h1>
            <p>
               �ı��<br> �ı��<br> �ı��<br> �ı��<br> �ı��<br>
            </p>
         </div>
      </div>
   </div>
</body>
</html>