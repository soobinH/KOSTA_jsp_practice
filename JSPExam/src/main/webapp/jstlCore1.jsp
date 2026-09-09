<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String test1 = "hello JSTL"; %>
<%=test1%>
<br>
<c:set var="test2" value="hello jstl"/>
<c:out value="${test2}"/> 

<c:remove var="test2"/>
<c:out value="${test2 }"/>
<br>

<c:catch var="err">
	<%=10/0 %>
</c:catch>
<c:out value="${err }"/>
<br>

<c:if test='${5<10 }'>
	5는 10보다 작다
</c:if>
<br>

<c:set var="value1" value="30"/>
<c:set var="value2" value="20"/>

<c:choose>
	<c:when test="${value1>value2 }">
		${value1 }는 ${value2 }보다 크다
	</c:when>
	<c:otherwise>
		${value1 }는 ${value2 }보다 작다
	</c:otherwise>
</c:choose>

</body>
</html>