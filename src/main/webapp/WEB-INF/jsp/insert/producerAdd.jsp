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
    <title>Title</title>
</head>
<body>
<form action="main" method="post">
    <input type="hidden" name="command" value="producerAddCommand">
    <p>Название производителя</p>
    <input type="text" name="producerName" placeholder="Введите название производителя">
    <p>Страна производства</p>
    <input type="text" name="producerCountry" placeholder="Введите страну производства">
    <button type="submit">Добавить</button>
</form>

<form action="main" method="get">
    <input type="hidden" name="command" value="Add">
    <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
