<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 01.04.2023
  Time: 16:44
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
  <input type="hidden" name="command" value="modelEditCommand">
  <input type="hidden" name="modelId" value="${requestScope.unit.model.id}">
  <p>Название модели</p>
  <input type="text" name="modelName" value="${requestScope.unit.model.name}">
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
