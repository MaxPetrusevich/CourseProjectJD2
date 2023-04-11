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
    <input type="hidden" name="command" value="techEditCommand">
    <input type="number" name="techPrice" placeholder="Введите цену">
    <select name="category">
        <c:choose>
            <c:when test="${requestScope.categories.size() > 0}">
                <c:forEach items="${requestScope.categories}" var="newCategory">
                            <option value="${newCategory.id}">
                                    ${newCategory.name}
                            </option>
                    </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <select name="producer">
        <c:choose>
            <c:when test="${requestScope.producers.size() > 0}">
                <c:forEach items="${requestScope.producers}" var="newProducer">
                            <option value="${newProducer.id}">
                                    ${newProducer.name}
                            </option>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <select name="model">
        <c:choose>
            <c:when test="${requestScope.models.size() > 0}">
                <c:forEach items="${requestScope.models}" var="newModel">
                            <option value="${newModel.id}">
                                    ${newModel.name}
                            </option>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <br>
    <c:if test="${requestScope.stores.size() > 0}">
        <c:forEach items="${requestScope.stores}" var="store">
            <h4>Магазины</h4>
            <div style="display: inline-block">
                <input type="checkbox" name="storeId" value="${store.id}">
                <p>${store.name} - ${store.address}</p>
            </div>
        </c:forEach>
    </c:if>
    <button type="submit">Добавить</button>
</form>

</body>
</html>
