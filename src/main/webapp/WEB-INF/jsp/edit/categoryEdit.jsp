<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 01.04.2023
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="main" method="post">
    <input type="hidden" name ="role" value="${requestScope.role}">
    <input type="hidden" name="status" value="${requestScope.status}">
    <input type="hidden" name="command" value="categoryEditCommand">
    <input type="hidden" name="categoryId" value="${requestScope.unit.category.id}">
    <input type="text" name="categoryName" value="${requestScope.unit.category.name}">
    <br>
    <div>
        <c:if test="${requestScope.types.size() > 0}">
            <c:forEach items="${requestScope.types}" var="type">
                <div style="display: inline-block">
                    <c:choose>
                        <c:when test="${type.category.id eq requestScope.unit.category.id}">
                            <input type="checkbox" checked name="typeId" value="${type.id}">
                            <p>${type.name}</p>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="typeId" value="${type.id}">
                            <p>${type.name}</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <button type="submit">Обновить</button>
</form>
<form action="main" method="get">
    <input type="hidden" name ="role" value="${requestScope.role}">
    <input type="hidden" name="status" value="${requestScope.status}">
    <input type="hidden" required name="tecId" value="${unit.id}">
    <input type="hidden" required name="command" value="Update">
    <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
