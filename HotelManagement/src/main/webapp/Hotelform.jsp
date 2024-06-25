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
<form:form action="savehoteldata" modelAttribute="Hotelobj">
 Enter the name:<form:input path="name"/><br>
 Enter the email:<form:input path="email"/><br><!-- we want to mention the properties inside the path -->
 Enter the password:<form:input type="password" path="password"/><br>
 Enter the address :<form:input path="address"/><br>
 Enter the mob:<form:input type="number" path="mobilenumber"/><br>
<input type="submit">
</form:form>
</body>
</html>