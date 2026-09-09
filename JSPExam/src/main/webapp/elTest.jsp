<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("name") %>님 환영합니다.</h1>
<h1>${param.name}님 환영합니다.</h1>

<p>email: <%=request.getAttribute("email") %></p>
<p>email: ${requestScope.email}</p>
<p>email: ${email }</p>

<p>address: <%=session.getAttribute("address") %></p>
<p>address: ${sessionScope.address }</p>
<p>address: ${address }</p>
</body>
</html>