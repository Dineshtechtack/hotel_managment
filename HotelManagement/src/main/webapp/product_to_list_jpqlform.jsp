<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product_to_list</title>
</head>
<body>
 <form:form action ="Save_products_into_list" modelAttribute="product_into_list">
 Enter the id<form:input path="id"/><br>
 Enter the name:<form:input path="name"/><br>
 Enter the email:<form:input path="cost"/><br>
 Enter the password:<form:input path="quantity"/><br>
 <input type="submit">
 </form:form>

</body>
</html>