<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr><th>순서</th><th>아이디</th><th>이름</th><th>주소</th><th>전화번호</th>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.users }" var="user" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.address }</td>
				<td>${user.tel }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>