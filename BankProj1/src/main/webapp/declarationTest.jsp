<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String str2 = "스크립틀릿 테스트입니다.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=getStr() %></h1>
	<%=str2 %>	
</body>
</html>
<%!
	private String getStr() {
		str+= "테스트입니다.";
		return str;
	}
	private String str = "선언문";
%>