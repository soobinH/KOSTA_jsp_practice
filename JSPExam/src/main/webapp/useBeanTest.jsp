<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<%-- <%
	User user = new User();
	user.setId("hong");
	user.setName("홍길동");
	user.setAddress("서울시 금천구");
	user.setTel("010-1234-4321");
%> --%>
<jsp:useBean id="user" class="bean.User"/>
<jsp:setProperty name="user" property="id" value="hong"/>
<jsp:setProperty name="user" property="name" value="홍길동"/>
<jsp:setProperty name="user" property="address" value="서울시 금천구"/>
<jsp:setProperty name="user" property="tel" value="010-1234-4321"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%=user.getId() %><br>
<%=user.getName() %><br>
<%=user.getAddress()%><br>
<%=user.getTel() %><br> --%>

<jsp:getProperty property="id" name="user"/><br>
<jsp:getProperty property="name" name="user"/><br>
<jsp:getProperty property="address" name="user"/><br>
<jsp:getProperty property="tel" name="user"/><br>

</body>
</html>