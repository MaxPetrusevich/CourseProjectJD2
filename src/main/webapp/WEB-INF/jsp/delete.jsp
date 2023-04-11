<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 03.04.2023
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Выберите удаляемый параметр</h3>
<form action="main" method="get">
  <input type="hidden" name="prevURL" value="/CourseProjectJD2?${pageContext.request.queryString}"/>
  <select name="command">
    <option value="">не выбрано</option>
    <option value="categoryDeleteCommand">Категория</option>
    <option value="typeDeleteCommand">Типы</option>
    <option value="modelDeleteCommand">Модель</option>
    <option value="producerDeleteCommand">Производитель</option>
    <option value="storeDeleteCommand">Магазины</option>
  </select>
  <button type="submit">Подтвердить</button>
</form>
<form action="main" method="get">
  <input type ="hidden" required name = "command" value ="Select">
  <button type="submit">Назад к списку</button>
</form>
</body>
</html>
