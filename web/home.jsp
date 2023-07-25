<%@ page import="java.util.List" %>
<%@ page import="models.Item" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navabr.jsp"%><br>
<div class="container">
  <table class="table table-bordered table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>NAME</th>
      <th>DESCRIPTION</th>
      <th>PRICE</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Item> items = (List<Item>) request.getAttribute("items");
      for (Item item : items) {
    %>
    <tr>
      <td><%= item.getId() %></td>
      <td><%= item.getName() %></td>
      <td><%= item.getDescription() %></td>
      <td><%= item.getPrice() %></td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>

