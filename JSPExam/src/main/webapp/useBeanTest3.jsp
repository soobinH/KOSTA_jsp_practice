<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% request.setCharacterEncoding("utf-8"); %>
    
 <jsp:useBean id="user" class="bean.User" scope="page"/>
 <jsp:setProperty name="user" property="*"/>
 
 
<%--  <jsp:setProperty name="user" property="id" param="id"/>
 <jsp:setProperty name="user" property="name" param="name"/>
 <jsp:setProperty name="user" property="address" param="address"/>
 <jsp:setProperty name="user" property="tel" param="tel"/> --%>
 
 
 
<%--  <jsp:setProperty name="user" property="id" value='<%request.getParameter("id")%>'/>
 <jsp:setProperty name="user" property="name" value='<%request.getParameter("name")%>'/>
 <jsp:setProperty name="user" property="address" value='<%request.getParameter("address")%>'/>
 <jsp:setProperty name="user" property="tel" value='<%request.getParameter("tel")%>'/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="id" name="user"/><br>
<jsp:getProperty property="name" name="user"/><br>
<jsp:getProperty property="address" name="user"/><br>
<jsp:getProperty property="tel" name="user"/><br>

</body>
</html>