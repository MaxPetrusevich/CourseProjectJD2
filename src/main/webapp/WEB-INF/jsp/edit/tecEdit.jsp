<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 02.04.2023
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="main" method="post">
    <input type="hidden" name ="role" value="${requestScope.role}">
    <input type="hidden" name="status" value="${requestScope.status}">
    <input type="hidden" name="command" value="techEditCommand">
    <input type="hidden" name="techId" value="${requestScope.unit.id}">
    <input type="number" name="techPrice" value="${requestScope.unit.price}">
    <select name="category">
        <c:choose>
            <c:when test="${requestScope.categories.size() > 0}">
                <c:forEach items="${requestScope.categories}" var="newCategory">
                    <c:choose>
                        <c:when test="${newCategory.id eq requestScope.unit.category.id}">
                            <option selected value="${newCategory.id}">${newCategory.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${newCategory.id}">
                                ${newCategory.name}
                            </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <select name="producer">
        <c:choose>
            <c:when test="${requestScope.producers.size() > 0}">
                <c:forEach items="${requestScope.producers}" var="newProducer">
                    <c:choose>
                        <c:when test="${newProducer.id eq requestScope.unit.producer.id}">
                            <option selected value="${newProducer.id}">${newProducer.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${newProducer.id}">
                                    ${newProducer.name}
                            </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <select name="model">
        <c:choose>
            <c:when test="${requestScope.models.size() > 0}">
                <c:forEach items="${requestScope.models}" var="newModel">
                    <c:choose>
                        <c:when test="${newModel.id eq requestScope.unit.model.id}">
                            <option selected value="${newModel.id}">${newModel.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${newModel.id}">
                                    ${newModel.name}
                            </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <br>
    <c:if test="${requestScope.stores.size() > 0}">
        <c:forEach items="${requestScope.stores}" var="store">
            <h4>МагазиныЖ</h4>
            <div style="display: inline-block">
                        <input type="checkbox" name="storeId" value="${store.id}">
                        <p>${store.name} - ${store.address}</p>
            </div>
        </c:forEach>
    </c:if>
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
