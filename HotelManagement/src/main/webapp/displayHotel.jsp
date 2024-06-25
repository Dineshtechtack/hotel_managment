<%@page import="com.hotelmangment.entites.Hotel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home page details</title>
</head>
<body>
<% List<Hotel> hotels= (List<Hotel>) request.getAttribute("listhotel") ;%>
<table>
<th>id</th>
<th>name</th>
<th>email</th>
<th>password</th>
<th>mobilenumber</th>
<th>address</th>
<th>status</th>
<%
for(Hotel hotel :hotels) {%>
<tr>
<td><%=hotel.getId()%></td>
<td><%=hotel.getName()%></td>
<td><%=hotel.getEmail()%></td>
<td><%=hotel.getPassword()%></td>
<td><%=hotel.getMobilenumber()%></td>
<td><%=hotel.getAddress()%></td>
<a href="approvehotel?id=<%=hotel.getId()%>"><td<%=hotel.getStatus()%>></td></a>
</tr>
<%} %>
</table>
</body>
</html>