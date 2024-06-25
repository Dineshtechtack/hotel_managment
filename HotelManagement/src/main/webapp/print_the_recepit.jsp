<%@page import="com.hotelmangment.entites.food_order"%>
<%@page import="com.hotelmangment.entites.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isElgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <% food_order cus=(food_order)session.getAttribute("ordercustomer");%>
 <table>
 <tr>
 <td>name</td>
  <td><%=cus.getName() %></td>
 </tr>
 <tr>
 <td>mobileNumber</td>
 <td><%=cus.getMobilenumber() %></td>
 </tr>
 <tr>
 <td>address</td>
 <td><%=cus.getAddress() %></td>
 </tr>
 <tr>
 <td>total_cost</td>
 <td><%=cus.getTotalcost() %></td>
 </tr>
 </table>
<a href="CustomerHomepsge.jdp">home</a>

</body>
</html>