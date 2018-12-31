<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Exercise</title>
</head>
<body>
<form method="post" action="admin-exercises">
    <p>Please enter details for <i>${exercise.title}</i>:</p>
    <p>Title: <input type="text" name="title"></p>
    <p>Description: <input type="text" name="description"></p>
    <input type="hidden" name="id" value="${exercise.id}">
    <input type="submit" value="OK">
</form>
</body>
</html>
