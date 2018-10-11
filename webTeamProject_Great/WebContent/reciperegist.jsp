<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
     var count = 2;
    function add_item(){
        // pre_set 에 있는 내용을 읽어와서 처리..
        
        var addedFormDiv = document.getElementById('field');//폼 생성
        
        /* div.innerHTML = document.getElementById('pre_set').innerHTML;
        document.getElementById('field').appendChild(div); */
        
       /*  <div class="form-group" id="pre_set" style="display:ture">
      <input type="text" class="form-control" name="way2" placeholder="요리방법 설명" style="width=50%">
      <input type="button" value="삭제" onclick="remove_item(this)">
      <input type="file" class="form-control" name="way2_url" placeholder="사진 업로드" name="way2_url">
   </div> */
        var str = "";
     
        str+="<br><input type='text' class='form-control' name=way_"+count+" placeholder='요리방법 설명' style='width=50%'>"
        str+="<input type='button' value='삭제' onclick='remove_item(this)'>"
        str+="<input type='file' class='form-control' name='way_"+count+"_url' placeholder='사진 업로드'><br>"
        
        var addedDiv = document.createElement("div"); // 폼 생성

        addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)

        addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입

        addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
        
        count++;   
        document.recipe.count.value=count;
    }
 
    function remove_item(obj){
        // obj.parentNode 를 이용하여 삭제
        document.getElementById('field').removeChild(obj.parentNode);
    }
</script>
</head>
<body>
   <c:import url="header.jsp"></c:import>
   <form action="insertrecipe.do" name="recipe" method="post" enctype="multipart/form-data">
      <div class="container">
         <div>
            <br><br>
            <h1 align="center">Recipe enroll</h1><br><br>
            <h5>음식이름</h5>
            <input type="text" class="form-control" name="name" placeholder="ex)김치볶음밥"   ><br><br>
            <h5>음식설명</h5>
            <input type="text" class="form-control" name="discript" placeholder="음식에 대한 설명을 간단하게 적어주세요"   ><br><br>
         </div>   
         <div>
            <h5>음식사진</h5>
            <div class="input-group">
            <input type="file" class="form-control" name="imgurls" placeholder="음식사진1" style="width=80%">
            <div class="input-group-btn">
            <button type="button" class="btn btn-enroll">upload</button></div></div>
            
         </div>
      </div>
      
      <div class="container">
      <h5>음식 분류</h5>
      <!-- 카테고리. 밸류값 해서 불러오자 -->
         <select id="type" name="type">
              <option value="구이류" selected="selected">구이</option>
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
            <input type="text" name="ingredient1" placeholder="주재료 1" required="required"><br><br>
            <input type="text" name="ingredient2" placeholder="주재료 2"><br><br>
            <input type="text" name="ingredient3" placeholder="주재료 3"><br><br>
         </div>
         <div  class="col-sm-4" >
            <h5>부재료</h5>
            <input type="text" name="sub_ingredient1" placeholder="부재료 1" required="required"><br><br>
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
            <div class="form-group" >
            	<br>
               <input type="text" class="form-control" name="way_1" placeholder="요리방법 설명" style="width=40%" required="required">
               <input type="file" align="left" class="form-control" name="way_1_url" placeholder="사진 업로드" name="way1_url"><br>
            </div>
             
            <div id="field"></div>
            <input type="hidden" name="count" value="0">
            
            <div align="center">
                <input type="button" value="추가" class="btn btn-primary"  onclick="add_item()">
            </div> 
         </div>
         <div>
            <h5><span class="badge badge-warning">Tip</span></h5>
            <div class="container">
                <div class="form-group">
                  <label for="tip">Comment</label>
                  <textarea class="form-control" rows="5" id="tip" name="tip"></textarea>
                </div>
             <div align="right">     
             <button type="button" class="btn btn-secondary" onclick="location.href='index.jsp'">취소하기</button>
             <input type="hidden" name="command" value="InsertRecipe">
             <button type="submit" class="btn btn-info">제출하기</button>
             </div>
            </div>
         </div>
      </div><br><br><br>
   </form>
   <c:import url="footer.jsp"></c:import>
</body>
</html>