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
<c:forEach var="test" begin="1" end="10" step="1">
	<b>${test}</b>
</c:forEach>
<br>

<c:forTokens items="a, b, c, d, e" delims="," var="alpha">
	<b>${alpha },</b>
</c:forTokens>
<br>

<c:set var="names" value="hong, song, kong"/>
<c:forTokens items="${names }" delims="," var="name">
	 <b>${name },</b>
</c:forTokens>
</body>
</html>