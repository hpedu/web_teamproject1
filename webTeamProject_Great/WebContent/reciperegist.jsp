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
   <form name="recipe" action="DispatcherServlet?command=reciperegist">
   <input type="submit" value ="send">
   <div class="container">
      <div>
         <br><br>
         <h1 align="center">Recipe enroll</h1><br><br>
         <h5>�����̸�</h5>
         <input type="text" class="form-control" name="name" placeholder="ex)��ġ������"   ><br><br>
      </div>   
      <div>
         <h5>���Ļ��� (�ּ� ������ ����ϼž� �մϴ�)</h5>
         <div class="input-group mb-3">
         <input type="file" class="form-control" placeholder="���Ļ���1" style="width=50%">
         <div class="input-group-append">
         <button type="button" class="btn btn-enroll">upload</button></div></div>
         <div class="input-group mb-3">
         <input type="file" class="form-control" placeholder="���Ļ���2" style="width=50%">
         <div class="input-group-append">
         <button type="button" class="btn btn-enroll">upload</button></div></div>
         <div class="input-group mb-3">
         <input type="file" class="form-control" placeholder="���Ļ���3" style="width=50%">
         <div class="input-group-append">
         <button type="button" class="btn btn-enroll">upload</button></div></div><br><br>
      </div>
   </div>
   
   <div class="container">
   <h5>���� �з�</h5>
   <!-- ī�װ�. ����� �ؼ� �ҷ����� -->
      <select id="type" name="category">
           <option value="����" selected="selected">����</option>
           <option value="���">���</option>
           <option value="���">���</option>
           <option value="������">������</option>
           <option value="����">����</option>
      </select>
   </div>
   <br><br>
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
            <input type="text" class="form-control" id="way1" placeholder="�丮��� ����" name="way1">
            <input type="file" align="left" class="form-control" id="way1_url" placeholder="���� ���ε�" name="way1_url">
         </div>
         <div class="form-group">
            <label for="email">2��:</label> 
            <input type="text" class="form-control" id="way2" placeholder="�丮��� ����" name="way2">
            <input type="file" class="form-control" id="way2_url" placeholder="���� ���ε�" name="way2_url">
         </div>
         <div class="form-group">
            <label for="email">3��:</label> 
            <input type="text" class="form-control" id="way3" placeholder="�丮��� ����" name="way3">
            <input type="file" class="form-control" id="way3_url" placeholder="���� ���ε�" name="way3_url">
         </div>
      </div>
      <div>
         <h5><span class="badge badge-warning">Tip</span></h5>
         <div class="container">
             <div class="form-group">
               <label for="comment">Comment</label>
               <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
             </div>
          <div align="right">     
          <button type="button" class="btn btn-default" onclick="location.href=url('index.jsp')">����ϱ�</button>
          <button type="submit" class="btn btn-info">����ϱ�</button>
          </div>
         </div>
      </div>
   </div><br><br><br>
   </form>
   <c:import url="footer.jsp"></c:import>
</body>
</html>