<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2, #paging, #tr_top { text-align: center; }
	table, #member, #paging { margin: auto; width:800px; }
	td, th { border: solid lightgray 1px; }
	td a { text-decoration: none; }
	#member { text-align: right; }
	#tr_top { background: orange }
	#paging a {
		display: inline-block;
		width:20px; height:20px; border:solid gray 1px;
		text-decoration: none;
	}
	#paging .select { background: lightblue; }
	#paging .btn { background: lightgray; }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>


</script>
</head>
<body>
<h2>글 목록&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${user ne Empty}">
		<a href="${contextPath}/article/write">글쓰기</a>
	</c:if>
	
</h2>
<div id="member">
	<a href="${contextPath}/member/login">로그인</a>
	<a href="${contextPath}/member/join">회원가입</a>
</div><br>
<table>
	<tr id="tr_top">
		<th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th><th>삭제</th>
	</tr>

</table>
<br>
<div id="paging">
</div>
</body>
</html>