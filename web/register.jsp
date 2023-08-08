<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="vendor/head.jsp" %>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container" style="min-height: 500px;">
    <div class="row mt-3">
        <div class="col-6 mx-auto">

            <% String emailError = request.getParameter("emailerror");
                if(emailError!=null){ %>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Электронная почта занята!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <% } %>

            <% String passwordError = request.getParameter("passworderror");
                if(passwordError!=null){ %>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Пароли не совпадают!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <% } %>

            <% String success = request.getParameter("success");
                if(success!=null){ %>

            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User added successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <% } %>
            <h1>Регистрация</h1>
            <form action="/register" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" required placeholder="Email" name="email" id="email">
                </div>

                <div class="form-group mt-3">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" required placeholder="Password" name="password" id="password">
                </div>

                <div class="form-group mt-3">
                    <label for="re_password">Repeat password:</label>
                    <input type="password" class="form-control" required placeholder="Repeat password" name="re_password" id="re_password">
                </div>

                <div class="form-group mt-3">
                    <label for="full_name">Full name:</label>
                    <input type="text" class="form-control" required placeholder="Full name" name="full_name" id="full_name">
                </div>
                    <a href="/signin.jsp" class="btn btn-primary">Назад</a>
                    <button type="submit" class="btn btn-success">ЗАРЕГИСТРИРОВАТЬСЯ</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
