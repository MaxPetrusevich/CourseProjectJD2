<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 01.04.2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="main" method="post">
    <input type="hidden" name ="role" value="${requestScope.role}">
    <input type="hidden" name="status" value="${requestScope.status}">
    <input type="hidden" name="command" value="typesEditCommand">
    <input type="hidden" name="typesCount" value="${requestScope.unit.category.types.size()}">
    <c:choose>
        <c:when test="${requestScope.unit.category.types.size()>0}">
            <c:forEach items="${requestScope.unit.category.types}" var="type" varStatus="status">
                <input type="text" name="typeName${status.count}" value="${type.name}">
                <input type="hidden" name ="typeId${status.count}" value="${type.id}">
            </c:forEach>
        </c:when>
    </c:choose>
    <button type="submit">Обновить</button>
</form>

<form action="main" method="get">
    <input type="hidden" name ="role" value="${requestScope.role}">
    <input type="hidden" name="status" value="${requestScope.status}">
    <input type="hidden" required name="techId" value="${unit.id}">
    <input type="hidden" required name="command" value="Update">
    <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
