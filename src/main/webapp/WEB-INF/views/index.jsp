<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Home Page</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <table>
        <tr>
            <th>Solution</th>
            <th>Author</th>
            <th>Created</th>
            <th>Details</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.exerciseId}</td>
                <td>${solution.userId}</td>
                <td>${solution.created}</td>
                <%--<c:url var="linkToSolution" value="/show-solution">--%>
                    <%--<c:param name="id" value="${solution.id}"}--%>
                <%--</c:url>--%>
                <td><a href="/show-solution?id=${solution.id}">link</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@ include file="footer.jsp"%>
</body>
</html>
