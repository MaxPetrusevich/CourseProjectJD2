<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 02.04.2023
  Time: 20:08
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
    <input type="hidden" name="command" value="storeAddCommand">
    <p>Название магазина</p>
    <input type="text" name="storeName" placeholder="Введите название магазина">
    <p>Адрес магазина</p>
    <input type="text" name="storeAddress" placeholder="Введите адрес магазина">
    <button type="submit">Добавить</button>
</form>

<form action="main" method="get">
    <input type="hidden" name="command" value="Add">
    <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
