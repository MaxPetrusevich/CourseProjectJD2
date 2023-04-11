<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 02.04.2023
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="main" method="post">
  <input type="hidden" name ="role" value="${requestScope.role}">
  <input type="hidden" name="status" value="${requestScope.status}">
  <input type="hidden" name="command" value="storeEditCommand">
  <input type="hidden" name="storesCount" value="${requestScope.unit.storeList.size()}">
  <c:choose>
    <c:when test="${requestScope.unit.storeList.size()>0}">
      <c:forEach items="${requestScope.unit.storeList}" var="store" varStatus="status">
        <input type="text" name="storeName${status.count}" value="${store.name}">
        <input type="text" name="storeAddress${status.count}" value="${store.address}">
        <input type="hidden" name ="storeId${status.count}" value="${store.id}">
      </c:forEach>
    </c:when>
  </c:choose>
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
