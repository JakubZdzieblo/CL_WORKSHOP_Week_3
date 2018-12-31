<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>User</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <h3>User details:</h3>
    <p>ID: ${user.id}</p>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <h3>Solutions by user:</h3>
    <c:forEach items="${solutions}" var="solution">
        <ul>
            <li>'${solution.description}', exercise ${solution.exerciseId}, created ${solution.created}</li>
        </ul>
    </c:forEach>
    <%@ include file="footer.jsp"%>
</body>
</html>
