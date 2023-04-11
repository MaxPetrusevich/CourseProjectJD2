<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 03.04.2023
  Time: 1:23
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
  <input type="hidden" name="command" value="modelDeleteCommand">
  <br>
  <div>
    <c:if test="${requestScope.models.size() > 0}">
      <c:forEach items="${requestScope.models}" var="model">
        <div style="display: inline-block">
              <input type="checkbox" name="modelId" value="${model.id}">
              <p>${model.name}</p>
        </div>
      </c:forEach>
    </c:if>
  </div>
  <button type="submit">Удалить</button>
</form>
<form action="main" method="get">
  <input type="hidden" required name="command" value="Delete">
  <button type="submit">Назад в меню выбора</button>
</form>
</body>
</html>
