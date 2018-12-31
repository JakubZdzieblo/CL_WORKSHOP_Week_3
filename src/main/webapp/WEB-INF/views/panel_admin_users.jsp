<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Users</title>
</head>
<body>

<h3>Available users:</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="edit-user?id=${user.id}">edit</a></td>
        </tr>
    </c:forEach>

</table>
<p><a href="edit-user?id=0">Add new user</a></p>
<p><a href="admin">Return to admin panel</a></p>


</body>
</html>
