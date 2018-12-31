<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Solution</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <h3>Solution view</h3>
    <p>Solution number ${solution.id} to exercise '${exercise.title}' by ${user.username}</p>
    <p>Created: ${solution.created}</p>
    <p>Updated: ${solution.updated}</p>
    <p>Exercise description: ${exercise.description}</p>
    <p>Solution: ${solution.description}</p>
    <%@ include file="footer.jsp"%>
</body>
</html>
