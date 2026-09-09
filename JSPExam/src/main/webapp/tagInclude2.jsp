<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%=request.getParameter("name") %>님의 사용자 정보</h2>
<hr>
<jsp:include page="tagInclude3.jsp">
<jsp:param value="010-1234-4321" name="tel"/>

</jsp:include>
</body>
</html>