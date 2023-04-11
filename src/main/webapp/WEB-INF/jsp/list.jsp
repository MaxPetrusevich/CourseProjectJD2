<%--
  Created by IntelliJ IDEA.
  User: lomic
  Date: 12.03.2023
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="index.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Document</title>
</head>
<body>
<div class="app">
    <div class="container">
        <c:choose>
        <c:when test="${requestScope.status eq 'Auto'}">
        <c:choose>
            <c:when test="${requestScope.list.size()>0}">
                <div class="header">
                    <div class="header-button">
                        <span style="color: black"> Сортировать по: </span>
                        <form action="main" method="post">

                            <input type="hidden" name ="role" value="${requestScope.role}">
                            <input type="hidden" name="status" value="${requestScope.status}">
                            <input type="hidden" required name="command" value="SortAsc">
                            <button type="submit" class="button">По цене</button>
                        </form>
                        <form action="main" method="post">

                            <input type="hidden" name ="role" value="${requestScope.role}">
                            <input type="hidden" name="status" value="${requestScope.status}">
                            <input type="hidden" name="command" value="findByPrice">
                            <input type="number" required name="minPrice" placeholder="Введите минимальную цену">
                            <input type="number" required name="maxPrice" placeholder="Введите максимальную цену">
                            <button type="submit">Подтвердить</button>
                        </form>
                        <form action="main" method="post">

                            <input type="hidden" name ="role" value="${requestScope.role}">
                            <input type="hidden" name="status" value="${requestScope.status}">
                            <input type="hidden" name="command" value="findByModel">
                            <input type="text" required name="model" placeholder="Введите название модели">
                            <button type="submit">Подтвердить</button>
                        </form>

                        <form action="main" method="post">

                            <input type="hidden" name ="role" value="${requestScope.role}">
                            <input type="hidden" name="status" value="${requestScope.status}">
                            <input type="hidden" name="command" value="findByProducer">
                            <input type="text" required name="producer" placeholder="Введите название производителя">
                            <button type="submit">Подтвердить</button>
                        </form>
                    </div>
                    <hr>
                </div>
                <div class="prod" style="display: inline-block">

                    <table class="w3-table-all w3-hoverable">
                        <tr>
                            <th>Номер</th>
                            <th>Страна производства</th>
                            <th>Производитель</th>
                            <th>Категория</th>
                            <th>Типы</th>
                            <th>Модель</th>
                            <th>Цена</th>
                            <th>В наличии</th>
                        </tr>
                        <c:forEach items="${requestScope.list}" var="unit" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${unit.producer.country}</td>
                            <td>${unit.producer.name}</td>
                            <td>${unit.category.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${unit.category.types.size() > 0}">
                                        <c:forEach items="${unit.category.types}" var="type">
                                            <p>${type.name}</p>
                                        </c:forEach>
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>${unit.model.name}</td>
                            <td>${unit.price}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${unit.storeList.size() > 0}">
                                        <c:forEach items="${unit.storeList}" var="store">
                                            <p>${store.name}; ${store.address}</p>
                                        </c:forEach>
                                    </c:when>
                                </c:choose>
                            </td>
                            <c:if test="${requestScope.role eq 'Admin'}">
                                <td>
                                    <form action="main" method="get">
                                        <input type="hidden" name ="role" value="${requestScope.role}">
                                        <input type="hidden" name="status" value="${requestScope.status}">
                                        <input type="hidden" required name="techId" value="${unit.id}">
                                        <input type="hidden" required name="command" value="Update">
                                        <button type="submit">Редактировать</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="main" method="post">

                                        <input type="hidden" name ="role" value="${requestScope.role}">
                                        <input type="hidden" name="status" value="${requestScope.status}">
                                        <input type="hidden" required name="techId" value="${unit.id}">
                                        <input type="hidden" required name="command" value="techDeleteCommand">
                                        <button type="submit">Удалить</button>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                        </c:forEach>
                </div>
                <div class="nav" style="display: inline-block">
                    <div>
                        <form action="main" method="post">

                            <input type="hidden" name ="role" value="${requestScope.role}">
                            <input type="hidden" name="status" value="${requestScope.status}">
                            <input type="hidden" name="command" value="findByCategory">
                            <input type="hidden" name="selectStatus" value="selected">
                            <select name="category">
                                <option value="">Выберите категорию</option>
                                <c:choose>
                                    <c:when test="${requestScope.categories.size()>0}">
                                        <c:forEach items="${requestScope.categories}" var="newCategory"
                                                   varStatus="status">
                                            <option value="${newCategory.id}">${status.count}. ${newCategory.name}</option>
                                        </c:forEach>
                                    </c:when>
                                </c:choose>
                            </select>
                            <button type="submit">Подтвердить</button>
                        </form>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>Список пуст</h3>
            </c:otherwise>
        </c:choose>
        <div class="footer">
                <%--
                            <select name="pageSize">
                                <option  onclick="">5</option>
                                <option  onclick=" ">10</option>
                                <option  onclick="">15</option>
                            </select>--%>
                <%-- <nav aria-label="Page navigation example">
                     <ul class="pagination footer-pag">
                         <c:if test="${(requestScope.count / requestScope.pageSize + 1 )> 1}">
                             <li class="page-item"><a class="page-link" href="main?command=Select&pageSize=5&pageNumber=${requestScope.currentPage - 1}">Previous</a></li>
                         </c:if>
                         <c:forEach begin="1" end="${requestScope.count / requestScope.pageSize + 1}" var="i">
                             <li class="page-item"><a class="page-link" href="main?command=Select&pageSize=5&pageNumber=${i}">${i}</a></li>
                         </c:forEach>
                         <c:if test="${(requestScope.count / requestScope.pageSize + 1) > requestScope.currentPage}">
                             <li class="page-item"><a class="page-link" href="main?command=Select&pageSize=5&pageNumber=${requestScope.currentPage + 1}">Next</a></li>
                         </c:if>
                     </ul>
                 </nav>--%>
            <c:if test="${requestScope.role eq 'Admin'}">
                <form action="main" method="get">
                    <input type="hidden" name ="role" value="${requestScope.role}">
                    <input type="hidden" name="status" value="${requestScope.status}">
                    <input type="hidden" name="command" value="Add">
                    <button type="submit">Добавить</button>
                </form>
                <form action="main" method="get">
                    <input type="hidden" name ="role" value="${requestScope.role}">
                    <input type="hidden" name="status" value="${requestScope.status}">
                    <input type="hidden" name="command" value="Delete">
                    <button type="submit">Удалить</button>
                </form>
            </c:if>
        </div>
    </div>
</div>
</c:when>
<c:otherwise>
    <h2>Вы не были авторизированы!</h2>
</c:otherwise>
</c:choose>
<button class="w3-btn w3-light-blue w3-round-large" onclick='location.href="index.jsp"'>
    Вернуться на главную
</button>
</body>
</html>

