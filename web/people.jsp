<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="vendor/head.jsp" %>
</head>
<body>
<%@ include file="vendor/navabr.jsp" %>
<%
    User users = (User) request.getSession().getAttribute("currentUser");
    if (users != null) {
        // Проверка наличия атрибута "successMessage"
        String successMessage = (String) request.getAttribute("successMessage");
        if (successMessage != null && !successMessage.isEmpty()) {
%>
<div class="alert alert-success" role="alert">
    <%= successMessage %>
</div>
<%
        // Сбросить сообщение об успешном обновлении после отображения
        request.removeAttribute("successMessage");
    }
%>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Email: <%= users.getEmail() %></h1><br>
        <hr class="my-4">
        <h1 class="display-4">Password: <%= users.getPassword() %></h1><br>
        <hr class="my-4">
        <h1 class="display-4">Full Name: <%= users.getFullName() %></h1><br>
    </div>
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#peopleTaskModal">
        + Редактировать
    </button>
</div>
<form action="/people" method="post">
    <div class="modal fade" id="peopleTaskModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Редактировать профиль</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="user_id" value="<%= users.getId() %>">
                    <label>Email:</label>
                    <input name="user_email" type="email" class="form-control" value="<%= users.getEmail() %>" readonly>
                    <label class="mt-3">Password:</label>
                    <input name="user_password" type="password" class="form-control" value="<%= users.getPassword() %>">
                    <label class="mt-3">Full Name:</label>
                    <input name="user_full_name" type="text" class="form-control" value="<%= users.getFullName() %>">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Редактировать профиль</button>
                </div>
            </div>
        </div>
    </div>
</form>
<%
    }
%>
</body>
</html>

