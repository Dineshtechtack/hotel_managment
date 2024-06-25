<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerRegister</title>
</head>
<body>
 <form:form action ="saveCustomerData" modelAttribute="Customerobj"><!-- modelattribute is used to get the model object -->
 Enter the name:<form:input path="name"/><br>
 Enter the email:<form:input path="email"/><br><!-- we want to mention the properties inside the path -->
 Enter the password:<form:input path="password"/><br>
 Enter the mobilenumber:<form:input path="mobilenumber"/><br>
 Enter the address:<form:input path="Address"/><br>
<input type="submit">
 </form:form>
</body>
</html>