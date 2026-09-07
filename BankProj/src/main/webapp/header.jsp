<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	#bankHeader {
		background-color: lightgray;
		height:100px;
	}
	h1 {
		text-align:center;
		padding: 10px auto;
	}
	ul {
		margin: 5px;
	}
	li {
		display :inline-block;
		list-style: none;
		float:left;
		text-align:center;
	}
	li>a {
		text-decoration: none;
	}
</style>
<%
	String id = (String)session.getAttribute("id");
%>
<div id="bankHeader">
	<h1><i>kosta bank</i></h1>
	<div>
		<ul style="float:right">
			<li>
			<%if(id==null) { %>
			<a href="login">로그인</a>
			<%} else { %>
			<%=id %>님 환영합니다.&nbsp;
			<a href="logout">로그아웃</a>
			<%} %>
			&nbsp;&nbsp;&nbsp;</li>
			<li><a href="join">회원가입</a>&nbsp;&nbsp;&nbsp;</li>
		</ul>
		<ul style="float:left">
			<li><a href="makeaccount.jsp">계좌개설</a>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="deposit.jsp">입금</a>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="withdraw.jsp">출금</a>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="accountInfo.jsp">계좌조회</a>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="transfer.jsp">계좌이체</a>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="allaccountinfo.jsp">전체계좌조회</a></li>			
		</ul>
	</div>
</div>