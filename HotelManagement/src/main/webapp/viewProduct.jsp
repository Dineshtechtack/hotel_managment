<%@page import="java.util.List"%>
<%@page import="com.hotelmangment.entites.product"%>
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
<%List<product>products =(List<product>)request.getAttribute("viewproducts");%>
<table border=2px cellspacing="2px ">
<tr>
<th>id</th>
<th>name</th>
<th>type</eth>
<th>discount</th>
<th>cost</th>
<th>add_to_list</th>
</tr>
<tr>
<%for(product product1:products) {%>
<td><%=product1.getId()%></td>
<td><%=product1.getName() %></td>
<td><%=product1.getType()%></td>
<td><%=product1.getDiscount() %></td>
<td><%=product1.getCost() %></td>
<td><a>add_to_list</a></td>
<%} %>
</tr>
</table>
</body>
</html>