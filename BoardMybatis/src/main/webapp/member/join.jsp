<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.header { text-align:center; }
	.wrap {
		margin : 0 auto;
		border : 1px solid;
		width : 260px;
		padding: 10px;
	}
	.row { height : 30px; }
	.title {
		float:left;
		width:70px;
		text-align:center;
		font-weight:bold;
	}
	.input {float:left;}
	input[type='submit'] {
		font-weight:bold;
		width:120px;
		background-color:lightgray;
		display: block;
		margin : 0 auto;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	
</script>

<script src="//t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<form action="join" method="post">
		<div><h3 class="header">회원가입</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id" id="id" style="width:117px"/></div>
				<div class="input">&nbsp;<button id="doubleId">중복</button></div>
			</div>
			<div class="row">  
				<div class="title">이름</div>
				<div class="input"><input type="text" name="name"/></div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text" name="password"/></div>
			</div>
			<div class="row">  
				<div class="title">이메일</div>
				<div class="input"><input type="text" name="email"/></div>
			</div>
			<div class="row">  
				<div class="title">우편번호</div>
				<div class="input"><input type="text" name="postcode" id="postcode" style="width:93px" readonly="readonly"/></div>
				<div class="input">&nbsp;<button id="searchAddress" id="searchAddress">주소찾기</button></div>			
			</div>
			<div class="row">  
				<div class="title">주소</div>
				<div class="input"><input type="text" name="address" id="address" readonly="readonly"/></div>
			</div>
			<div class="row">  
				<div class="title">상세주소</div>
				<div class="input"><input type="text" name="detailAddress" id="detailAddress"/></div>
			</div>
			<div>
				<input type="submit" value="회원가입"/>
			</div>
		</div>
	</form>
</body>
</html>