<%@page import="com.hotelmangment.entites.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table
{
    border-collapse: collapse;
    width:50%;
    text-align: center;
}
td,th
{
padding:10px;
}
</style>
</head>
<body>
<% List<product>prod=(List<product>)request.getAttribute("rangeofproducts"); %>
<table border=2px >
<tr>
<th>id</th>
<th>name</th>
<th>type</th>
<th>cost</th>
<th>discount</th>
<th>cart</th>
</tr>
<%for(product pro:prod){ %>
<tr>
<td><%=pro.getId() %></td>
<td><%=pro.getName() %></td>
<td><%=pro.getType() %></td>
<td><%=pro.getCost()%></td>
<td><%=pro.getDiscount() %></td>
<td><a href="addproducts?id=<%=pro.getId() %>">add</a></td>
</tr>
<%} %>
</table>
<button><a href="showlistofitems">buy_product</a></button>
</body>
</html>