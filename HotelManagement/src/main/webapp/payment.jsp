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
<form:form action ="savedata" modelAttribute="addcustomerobj">
 Enter the name:<form:input readonly path="name"/><br>
 Enter the mobile_number:<form:input readonly path="mobilenumber"/><br>
 Enter the password:<form:input readonly path="address"/><br>
 Enter the address:<form:input readonly path="totalcost"/><br>
 <a href="procide_to_pay">procide_to_pay</a>
 <input type="submit" value="procide to pay">
</form:form>
</body>
</html>