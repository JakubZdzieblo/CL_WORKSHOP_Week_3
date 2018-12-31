<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Groups</title>
</head>
<body>

<h3>Available groups:</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${groups}" var="group">
    <tr>
        <td>${group.id}</td>
        <td>${group.name}</td>
        <td><a href="/edit-group?id=${group.id}">edit</a></td>
    </tr>
    </c:forEach>
</table>
<p><a href="/edit-group?id=0">Add new group</a></p>
<p><a href="/admin">Return to admin panel</a></p>

</body>
</html>
