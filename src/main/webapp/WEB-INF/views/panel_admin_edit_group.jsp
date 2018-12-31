<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Group</title>
</head>
<body>
    <form method="post" action="/admin-groups">
        Please enter new name for the group <i>${name}</i>:
        <input type="text" name="groupname">
        <input type="hidden" name="id" value="${id}">
        <input type="submit" value="OK">
    </form>
</body>
</html>
