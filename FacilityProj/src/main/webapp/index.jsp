<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LG사이언스파크</title>
<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
const contextPath = '${pageContext.request.contextPath}';
console.log(contextPath);

</script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
<div class="login">
	<form id="loginForm" action="<c:url value="/member/login"/>" method="post">
	<c:choose>
		<c:when test="${sessionScope.user ne Empty }">
			<h2 style="color:black"><span style="margin-left:150px;">${sessionScope.user.name } 님 안녕하세요</span>&nbsp;&nbsp;
			<a href="${contextPath}/member/logout">로그아웃</a>&nbsp;&nbsp;</h2>
		</c:when>
		<c:otherwise>
			<input type="text" name="id" placeholder="사번" required maxlength="5" autofocus>
			<input type="password" name="pw" placeholder="비밀번호" required>
			<button type="submit">로그인</button>
			<button type="button" id="signUpBtn">회원가입</button>
		</c:otherwise>
	</c:choose>
		
	</form>
</div>
</body>
</html>