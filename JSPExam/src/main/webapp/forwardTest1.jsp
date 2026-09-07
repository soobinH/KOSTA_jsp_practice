<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward test</h1>
<form action="forwardTest2.jsp" method="post">
	<input type="hidden" name="forwardPage" value="forwardTest3.jsp">
	<table border="1">
		<tr><td>이름</td><td><input type="text" name="name"> </td></tr>
		<tr><td>나이</td><td><input type="text" name="age"> </td></tr>
		<tr><td>주소</td><td><input type="text" name="address"> </td></tr>
		<tr><td colspan="2"><input type="submit" value="전송"></td></tr>
	</table>

</form>
</body>
</html>