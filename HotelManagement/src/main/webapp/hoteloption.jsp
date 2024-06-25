<%@page import="com.hotelmangment.entites.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%     // security porpose 
Integer hotel=(Integer)session.getAttribute("Hotelinfo");
if(hotel!=null) {
%>
<a href="addproduct">Add product</a><br>
<a href="viewAllproduct">view all product</a><br>
<a href="updateProducts">Update product</a><br>
<a href="deleteproduct">Delete Product BY id</a>
<%
}else{
%>
<a href="HotelLogin.jsp">Login first</a>
<%} %>
</body>
</html>