<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form:form action ="procide_to_pay" modelAttribute="addcustomerobj"><!-- modelattribute is used to get the model object -->
 Enter the name:<form:input path="name"/><br>
 Enter the mobile_number:<form:input  path="mobilenumber"/><br><!-- we want to mention the properties inside the path -->
 Enter the password:<form:input  path="address"/><br>
 Enter the address:<form:input  path="totalcost"/><br>
 <a href="procide_to_pay" >procide_to_pay</a>
 <input type="submit" value="procide to pay">
 
 </form:form>
 </body>
</html>