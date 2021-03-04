<%@page import="ru.aplana.logic.Model" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.03.2021
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h1>Домашняя страница по работе с пользователями</h1>
    <p>Введите ID пользователя (0 - для вывода списка)</p>
    <br/>
  Доступно: <%
      Model model = Model.getInstance();
      out.print(model.getFromList().size());
    %>
  <form method="get" action="get">
    <label>ID:
      <input type="text" name="id"><br/>
    </label>
    <button type="submit">Поиск</button>
  </form>
  <a href="addUser.html">Создать нового пользователя</a>
  </body>
</html>
