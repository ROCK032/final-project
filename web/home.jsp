<%@ page import="java.util.List" %>
<%@ page import="models.Item" %>
<%@ page import="models.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ include file="vendor/head.jsp" %>
</head>
<body>
<%@ include file="vendor/navabr.jsp" %>
<hr class="my-1"><br>
<h1 style="text-align: center;">Welcome To Bitlab News</h1>
<h6 style="text-align: center;color: #4d5154">Only up-to-date news and verified</h6><br>

<div class="container">
  <table class="table table-bordered table-striped">
    <thead>
    <tr>
      <th>Тема:</th>
      <th>Новости:</th>
      <th>Время:</th>
      <th>Полная версия</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Item> items = (List<Item>) request.getAttribute("items");
      for (Item item : items) {
    %>
    <tr>
      <td><%= item.getName() %></td>
      <td><%= item.getDescription() %></td>
      <td><%= item.getPrice() %></td>
      <td><a href="/details?id=<%=item.getId()%>" class="btn btn-info btn-sm" style="    color: white;background-color: #0f5132">Продолжение</a> </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>


