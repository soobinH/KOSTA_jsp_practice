<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr><th>아이디</th><td><%=id %></td></tr>
	<tr><th>비밀번호</th><td><%=password %></td></tr>
	</table>

</body>
</html>