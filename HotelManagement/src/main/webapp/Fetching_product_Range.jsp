<%@page import="com.hotelmangment.entites.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Displayprodcuts_range</title>
</head>
<body>

<form action="rangeof_the_product">
<input type="number"   name="range_of_starting_price"> 
<input type="number" name="range_of_ending_price">
<input type="submit">
</form>
<% List<product>prod=(List<product>)request.getAttribute("rangeofproducts"); %>
<table>
<tr>
<th>id</th>
<th>name</th>
<th>type</th>
<th>cost</th>
<th>discount</th>
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
<%}%>

</table>
  
</body>
</html>