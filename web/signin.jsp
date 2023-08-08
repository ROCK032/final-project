<%@ page import="java.util.List" %>
<%@ page import="models.Item" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ include file="vendor/head.jsp" %>
</head>
<body>
<form action="/auth" method="post">
  <%
    String error = request.getParameter("error");
    if(error!= null && error.equals("1")){
  %>
  <div class="alert alert-danger alert-dismissible fade show" role="alert">
    <strong>ERROR</strong>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
  <%
    }
  %>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h2 class="text-center mb-4">Вход</h2>
        <form action="login" method="post">
          <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Пароль:</label>
            <input type="password" class="form-control" id="password" name="password" required>
          </div>
          <button type="submit" class="btn btn-primary">Войти</button>
          <a href="/register.jsp" class="btn btn-success">Зарегистрироваться</a>
        </form>
      </div>
    </div>
  </div>
</form>
</body>
</html>


