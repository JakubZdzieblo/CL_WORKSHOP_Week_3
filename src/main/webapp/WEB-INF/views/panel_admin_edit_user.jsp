<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form method="post" action="admin-users">
    <p>Please enter details for <i>${user.username}</i>:</p>
    <p>Name: <input type="text" name="username"></p>
    <p>Password: <input type="password" name="password"></p>
    <p>Email: <input type="text" name="email"></p>
    <p>Group: <select name="groupid">
        <c:forEach items="${groups}" var="group">
        <option value="${group.id}">${group.name}</option>
        </c:forEach>
    </select></p>
    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="OK">
</form>
</body>
</html>
