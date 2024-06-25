<%@page import="com.hotelmangment.entites.Hotel"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Hotel> hotels= (List<Hotel>) request.getAttribute("block") ;%>
<table border=2px >
<tr >
<th>id</th>
<th>name</th>
<th>email</th>
<th>password</th>
<th>mobilenumber</th>
<th>address</th>
<th>status</th>
<th>status</th>

</tr>
<%
for(Hotel hotel :hotels) {%>
<tr>
<td><%=hotel.getId()%></td>
<td><%=hotel.getName()%></td>
<td><%=hotel.getEmail()%></td>
<td><%=hotel.getPassword()%></td>
<td><%=hotel.getMobilenumber()%></td>
<td><%=hotel.getAddress()%></td>
<td><%=hotel.getStatus()%></td>
<td><a href="unblock?id=<%=hotel.getId()%>">unblock</a></td>
</tr>
<%} %>
</table>
<button><a href="Adminoption.jsp">home</a></button>
<button><a href="Adminlogin.jsp">logout</a></button>

</body>
</html>