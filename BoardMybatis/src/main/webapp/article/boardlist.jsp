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
	
	.delBtn {
		display: inline-block; 
		padding: 5px; 
		background-color: #007bff; /* 버튼 색상 */ 
		color: #fff; /* 글자 색상 */ 
		text-decoration: none; /* 밑줄 제거 */ 
		border-radius: 5px; /* 둥근 모서리 */ 
		font-weight: bold;
	}
	
	.delBtn[disabled] {
		  background-color: #ccc;
		  color: #666;
		  pointer-events: none; /* 클릭 방지 */
		  cursor: not-allowed;
		}
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
	<c:choose>
			<c:when test="${sessionScope.user ne Empty}">
			<img src='<c:choose>
						<c:when test="${sessionScope.profile ne Empty}">
							${contextPath }/img/bear.png
						</c:when>
						<c:otherwise>
						${contextPath }profile?filename=${sessionScope.user.profile}
						</c:otherwise>
					</c:choose>'
				
				width="70px"style="border-radius:50%;"/>
			
			<span>${sessionScope.user.name }</span>&nbsp;&nbsp;
			<a href="${contextPath}/member/logout">로그아웃</a>&nbsp;&nbsp;
			</c:when>
		<c:otherwise>
			<a href="${contextPath}/member/login">로그인</a>&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>
	<a href="${contextPath}/member/join">회원가입</a>
	
	
</div><br>
<table>
	<tr id="tr_top">
		<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>삭제</th>
	</tr>
	<c:forEach items="${articleList }" var="article">
		<tr>
			<td>${article.num }</td>
			<td><a href="${contextPath }/article/detail?num=${article.num}">${article.title }</a></td>
			<td>${article.writer }</td>
			<td>${article.viewcnt }</td>
			<td><a class="delBtn" href="${contextPath}/article/delete?num=${article.num}&page=${pageInfo.curPage}" ${sessionScope.user.id eq article.writer?'':'disabled'}>삭제</a></td>
		</tr>
	</c:forEach>

</table>
<br>
<div id="paging">
	<a href="${pageInfo.curPage>1? contextPath+='/article/list?page='+=(pageInfo.curPage-1):'#'}">&lt</a>
	<c:forEach begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1" var="page">
		<a href="${contextPath }/article/list?page=${page}"
			class="${pageInfo.curPage eq page? 'select':'btn' }">${page }</a>
	</c:forEach>
	<a href="${pageInfo.curPage<pageInfo.allPage?contextPath+='/article/list?page='+=(pageInfo.curPage+1):'#'}">&gt</a>
</div>
</body>
</html>