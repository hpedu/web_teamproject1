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
           <img src="./img/recipe_main/KakaoTalk_20181001_102058345.jpg" class="rounded" alt="��ǰ����"
              style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
        </div>
        <div class="col-sm-8" style="padding: 20px;">
           <H3>
              	 <b>��ǰ��</b>  &nbsp;&nbsp;&nbsp; ������<%-- ${product.name} --%>
           </H3>
           <hr color="orange">
           <table style="width: 100%; height: 200px">
              <tr>
                 <td width="100px" height="5px"><b>��        ��   </b></td>
                 <td>��� <%-- ${product.type} --%></td>
              </tr>
              <tr>
                 <td><b>������   </b></td>
                 <td>������<%-- ${product.origin} --%>
                 </td>
              </tr>
              <tr>
                 <td><b>��        ��   </b></td>
                 <td>100�� <%-- ${product.price} --%></td>
              </tr>
              <tr>
                 <td><b>��        ��   </b></td>
                 <td>1kg <%-- ${product.sales_volume} --%></td>
              </tr>
              <tr>
                 <td><b>������   </b></td>
                 <td>? <%-- ${product.brand} --%></td>
              </tr>
           </table>
           <div style="text-align:right;">
           <button type="button" class="btn btn-warning" >��ٱ��� ���</button>&nbsp;&nbsp;&nbsp;
           <button type="button" class="btn btn-warning" >�����ϱ�</button>
           </div>
        </div>
     </div>
     
     
         
  <div class="menu" data-spy="scroll" data-target=".navbar" data-offset="50" align="center">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark"  style="text-align: center;">  
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#section1">������</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section2">�������</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section3">���û�ǰ</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section4">��ǰ����</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section5">��ǰ�ı�</a>
    </li>
  </ul>
</nav>

<div id="section1" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>������</h1>
  <p>������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  ������<br>
  </p>
</div>
<div id="section2" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>�������</h1>
  <p>�������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br>
  �������<br></p>
</div>
<div id="section3" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>���û�ǰ</h1>
  <p>��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br>
  ��ǰ����<br></p>
</div>
<div id="section4" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>��ǰ����</h1>
  <p>���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br>
  ���ǻ���<br></p>
</div>
<div id="section5" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
  <h1>��ǰ�ı�</h1>
  <p>�ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br>
  �ı��<br></p>
</div>
</div>
</div>
</body>
</html>
