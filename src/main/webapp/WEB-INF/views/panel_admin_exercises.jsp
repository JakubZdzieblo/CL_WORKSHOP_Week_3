<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Exercises</title>
</head>
<body>

<h3>Available exercises:</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${exercises}" var="exe">
        <tr>
            <td>${exe.id}</td>
            <td>${exe.title}</td>
            <td>${exe.description}</td>
            <td><a href="edit-exercise?id=${exe.id}">edit</a></td>
        </tr>
    </c:forEach>

</table>
<p><a href="edit-exercise?id=0">Add new exercise</a></p>
<p><a href="admin">Return to admin panel</a></p>

</body>
</html>
