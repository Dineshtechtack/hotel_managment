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
<% Hotel hotel =(Hotel)request.getAttribute("perticularhotel");%>
<table border=2px >
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>password</th>
<th>mobilenumber</th>
<th>address</th>
<th>products</th>
</tr>
<tr>
<td><%=hotel.getId()%></td>
<td><%=hotel.getName() %></td>
<td><%=hotel.getEmail() %></td>
<td><%=hotel.getPassword() %></td>
<td><%=hotel.getMobilenumber() %></td>
<td><%=hotel.getAddress() %></td>
<td><a href="viewproducts?id=<%=hotel.getId()%>">add</a>
</tr>
</table>
</body>
</html>