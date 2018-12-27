<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/header.jsp"%>
    <table>
        <tr>
            <th>Zadanie</th>
            <th>Autor</th>
            <th>Data utworzenia</th>
            <th>Akcje</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.exercise}</td>
                <td>${solution.userId}</td>
                <td>${solution.created}</td>
                <%--<c:url var="linkToSolution" value="/show-solution">--%>
                    <%--<c:param name="id" value="${solution.id}"}--%>
                <%--</c:url>--%>
                <td><a href="/show-solution?id=${solution.id}">Szczegóły</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
