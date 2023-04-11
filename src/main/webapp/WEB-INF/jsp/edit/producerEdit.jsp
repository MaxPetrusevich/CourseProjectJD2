<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 01.04.2023
  Time: 15:56
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
    <input type="hidden" name="command" value="producerEditCommand">
    <input type="hidden" name="producerId" value="${requestScope.unit.producer.id}">
    <p>Производитель</p>
    <input type="text" name="producerName" value="${requestScope.unit.producer.name}">
    <p>Страна производства</p>
    <input type="text" name="producerCountry" value="${requestScope.unit.producer.country}">
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
