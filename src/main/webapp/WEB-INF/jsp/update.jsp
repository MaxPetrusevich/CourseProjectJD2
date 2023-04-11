<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="jsp/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<div class="w3-container" style="margin-left:10px; width:400px;">
    <h3>Выберите параметр редактирования</h3>
    <form action="main" method="get">
        <input type="hidden" name ="role" value="${requestScope.role}">
        <input type="hidden" name="status" value="${requestScope.status}">
        <input type="hidden" name="prevURL" value="/CourseProjectJD2?${pageContext.request.queryString}"/>
        <input type ="hidden" name ="tecId" value="${requestScope.tecId}">
        <select name="command">
            <option value="">не выбрано</option>
            <option value="techEditCommand">Техника</option>
            <option value="categoryEditCommand">Категория</option>
            <option value="typesEditCommand">Типы</option>
            <option value="modelEditCommand">Модель</option>
            <option value="producerEditCommand">Производитель</option>
            <option value="storeEditCommand">Магазины</option>
        </select>
        <button type="submit">Подтвердить</button>
    </form>
    <form action="main" method="get">

        <input type="hidden" name ="role" value="${requestScope.role}">
        <input type="hidden" name="status" value="${requestScope.status}">
        <input type ="hidden" required name = "command" value ="Select">
        <button type="submit">Назад к списку</button>
    </form>
</div>
</body>
</html>