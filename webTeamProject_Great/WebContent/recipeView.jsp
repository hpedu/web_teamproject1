<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container">
		<div>
			<br><br>
			<h1 align="center">������ ���</h1><br><br>
			<h5>�����̸�</h5>
			<input type="text" class="form-control" placeholder="ex)��ġ������"	><br><br>
		</div>	
		<div>
			<h5>���Ļ��� (�ּ� ������ ����ϼž� �մϴ�)</h5>
			<div class="input-group mb-3">
			
			<input type="text" class="form-control" placeholder="���Ļ���" style="width=50%">
			<div class="input-group-append">
			<button type="button" class="btn btn-enroll">����ϱ�</button></div></div><br><br>
		</div>
	</div>
	<div class="container">
	<div class="row">
		<div class="col-sm-4" style="margin-right:20px;">
			<h5>�����</h5>
			<input type="text" name="ingredient1" placeholder="����� 1"><br><br>
			<input type="text" name="ingredient2" placeholder="����� 2"><br><br>
			<input type="text" name="ingredient3" placeholder="����� 3"><br><br>
		</div>
		<div  class="col-sm-4" >
			<h5>�����</h5>
			<input type="text" name="sub_ingredient1" placeholder="����� 1"><br><br>
			<input type="text" name="sub_ingredient2" placeholder="����� 2"><br><br>
			<input type="text" name="sub_ingredient3" placeholder="����� 3"><br><br>
		</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<div>
		<h5>�丮���</h5>
			<div class="form-group">
				<label for="email">1��:</label> 
				<input type="text" class="form-control" id="email" placeholder="�丮��� ����" name="email">
				<input type="file" align="left" class="form-control" id="email" placeholder="���� ���ε�" name="email">
			</div>
			<div class="form-group">
				<label for="email">2��:</label> 
				<input type="text" class="form-control" id="email" placeholder="�丮��� ����" name="email">
				<input type="file" class="form-control" id="email" placeholder="���� ���ε�" name="email">
			</div>
			<div class="form-group">
				<label for="email">3��:</label> 
				<input type="text" class="form-control" id="email" placeholder="�丮��� ����" name="email">
				<input type="file" class="form-control" id="email" placeholder="���� ���ε�" name="email">
			</div>
			<div class="form-group">
				<Button type="button"> tip </Button> 
				<input type="text" class="form-control" id="tip" placeholder="Enter tip"
					name="tip">
			</div>
			<button type="submit" class="btn btn-default">����ϱ�</button>
			<button type="submit" class="btn btn-default">����ϱ�</button>
	
		</div>
	</div>

</body>
</html>