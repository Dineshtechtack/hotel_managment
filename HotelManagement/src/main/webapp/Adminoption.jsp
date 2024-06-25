
<%@page import="com.hotelmangment.entites.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<%
Admin a=(Admin) session.getAttribute("adminfo");
if( a != null)
{
%>
<a href="unapprovel">unapprove hotel</a><br>
<a href="approvel">approve hotel</a><br>
<a href="blockhotels">block hotel</a><br>
<a href="unblockhotels">unblock hotel</a><br>
<a href="discount">provide discount</a>
<%}
else{
%>
<a href="adminlogin.jsp">login first</a>
<%} %>
</body>
</html>