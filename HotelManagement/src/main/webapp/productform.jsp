<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form:form action="saveproduct" modelAttribute="productobjs">
Enter product name	<form:input path="name"/><br>
Enter product type	<form:input path="type"/><br>
Enter product cost	<form:input path="cost"/><br>
Enter product discount	<form:input path="discount"/><br>
<input type="submit">
</form:form>
<body>

</body>
</html>