<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="regular-progression">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="jsp/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container" style="margin-left:10px; width:400px;">
    <h3>Добавить</h3>
    <form action="main" method="get">
        <input type="hidden" name="prevURL" value="/CourseProjectJD2?${pageContext.request.queryString}"/>
        <select name="command">
            <option value="">не выбрано</option>
            <option value="techAddCommand">Технику</option>
            <option value="categoryAddCommand">Категорию</option>
            <option value="typeAddCommand">Тип</option>
            <option value="modelAddCommand">Модель</option>
            <option value="producerAddCommand">Производителя</option>
            <option value="storeAddCommand">Магазин</option>
        </select>
        <button type="submit">Подтвердить</button>
    </form>

    <form action="main" method="get">
        <input type ="hidden" required name = "command" value ="Select">
        <button type="submit">Назад к списку</button>
    </form>
</div>
</body>
</html>
