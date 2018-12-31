<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Groups</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <table>
        <tr>
            <th>Group id</th>
            <th>Group name</th>
            <th>Users</th>
        </tr>
        <c:forEach items="${userGroups}" var="ug">
            <tr>
                <td>${ug.id}</td>
                <td>${ug.name}</td>
                <td><a href="/users-from-groups?id=${ug.id}">link</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@ include file="footer.jsp"%>
</body>
</html>
