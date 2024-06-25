
<%@page import="com.hotelmangment.entites.item"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<item> items=(List<item>)request.getAttribute("itemsobj") ;
%>
<table cellpadding="20px" border="2px">
<thead>
<tr>
	<th>name</th>
	<th>type</th>
	<th>quantity</th>
	<th>product cost</th>
	
</tr>
</thead>
<tbody>
<% for(item i:items){ %>
<tr>
	<td><%= i.getName() %></td>
	<td><%= i.getType() %></td>
	<td><%= i.getQuantity() %></td>
	<td><%= i.getCost() %></td>
	<td><a href="update?id=<%=i.getId()%>">update</a></td>
	<td><a href="delete?id=<%=i.getId()%>">delete</a></td>
</tr>
	<%} %>

</tbody>
</table>
<a href="order_items">order</a>
<a href="customeroption.jsp"><button> Goto Home</button></a>
<a href="customerhistory.jsp"><button>Goto history </button></a>
</body>
</html>