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
<%List<product>products =(List<product>)request.getAttribute("updateproducts");%>
<table border=2px cellspacing="2px ">
<tr>
<th>id</th>
<th>name</th>
<th>type</eth>
<th>discount</th>
<th>cost</th>
<th>update</th>
</tr>
<%for(product product1:products) {%>
<tr>
<td><%=product1.getId()%></td>
<td><%=product1.getName() %></td>
<td><%=product1.getType()%></td>
<td><%=product1.getDiscount() %></td>
<td><%=product1.getCost() %></td>
<td><a href="#">update</a>
</tr>
<%} %>
</table>
<button><a href="hoteloption.jsp" >hotel</a></button>
</body>
</html>