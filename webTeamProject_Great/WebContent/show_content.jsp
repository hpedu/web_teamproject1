<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"></c:import>
<table cellpadding="5">
<tr>
	<td>
		<table width="550" text-align="center">
			<tr>
				<td>No. : ${rvo.no}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">
				    조회수 : ${requestScope.rvo.hits}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">
				    작 성 자 : ${requestScope.rvo.writer}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">		
				    제    목 : ${requestScope.rvo.title}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">	
				    작성일시 : ${requestScope.rvo.register_date}	 
				   &nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<hr style="color: #6691BC; margin: 0">
					<pre>${requestScope.rvo.content}</pre>
				</td>
			</tr>
			<tr>
				<td valign="middle">
				<a href="DispatcherServlet?command=ShowList&&pageNo=1">
				<img alt="목록" src="img/list_btn.jpg" border="0"></a>
				</td>			
			</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>
















