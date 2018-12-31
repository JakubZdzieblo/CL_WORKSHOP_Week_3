<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Users from group</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h3>List of users from group '${group.name}':</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Details</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="/show-user?id=${user.id}">link</a></td>
            </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp"%>
</body>
</html>
