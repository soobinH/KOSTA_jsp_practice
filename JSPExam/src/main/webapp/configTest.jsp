<%@ page import = "java.util.Enumeration" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String fileDir = config.getInitParameter("fileDir");
	String fileName = config.getInitParameter("fileName");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>config test</h2>
<img src="<%=fileDir %><%=fileName %>" alt="<%=fileName %>" width="200"/>

</body>
</html>