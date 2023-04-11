<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 02.04.2023
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
<form action="main" method="post">
    <input type="hidden" name="command" value="categoryAddCommand">
    <p>Название категории</p>
    <input type="text" name="categoryName" placeholder="Введите название категории">
    <br>
    <div>
        <c:if test="${requestScope.types.size() > 0}">
            <c:forEach items="${requestScope.types}" var="type">
                <div style="display: inline-block">
                    <input type="checkbox" name="typeId" value="${type.id}">
                    <p>${type.name}</p>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <button type="submit">Добавить</button>
</form>
<form action="main" method="get">
    <input type="hidden" name="command" value="Add">
    <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
