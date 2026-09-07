<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
 <% String message = request.getParameter("message"); %>
 <span style="color: red"><b><%=message %></b></span>