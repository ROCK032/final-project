<%@ page import="models.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="vendor/head.jsp" %>
</head>
<body>
<%@ include file="vendor/navabr.jsp" %>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <%-- Проверяем, что объект item не равен null --%>
            <%
                Item item = (Item) request.getAttribute("danne");
                if(item!=null){
            %>
            <div class="jumbotron">
                <h1 class="display-4"><%= item.getName() %></h1>
                <hr class="my-4">
                <h1><%= item.getPrice() %></h1>
                <hr class="my-4">
                <h1><%= item.getSpecification() %></h1>
                <hr class="my-4">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                <h1><%= item.getDescription() %></h1></div>
                <%
                        user = (User) request.getSession().getAttribute("currentUser");
                        if(user != null && user.getEmail().equals("china@gmail.com")) {

                    %>
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editTaskModal">
                        + Редактировать
                    </button>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteTaskModal">
                    Удалить
                </button>
                    <%
                        }
                    %>
                </div>
            </div>
                <form action="/edit-task" method="post">
                    <div class="modal fade" id="editTaskModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Редактировать новости</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" value="<%=item.getId()%>"name="item_id">
                                    <label>Subject:</label>
                                    <input name="item_name" type="text" class="form-control" value="<%=item.getName()%>">
                                    <label class="mt-3">News:</label>
                                    <input name="item_specification" type="text" class="form-control" value="<%=item.getSpecification()%>">
                                    <label class="mt-3">Description:</label>
                                    <textarea name="item_description" class="form-control"><%=item.getDescription()%></textarea>
                                    <label class="mt-3">Time:</label>
                                    <input name="item_price" type="text" class="form-control" step="any" value="<%=item.getPrice()%>">
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Редактировать новости</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
        <form action="/delete-task" method="post">
            <div class="modal fade" id="deleteTaskModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" >Вы уверены что хотите удалить?</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <input type="hidden"value="<%=item.getId()%>" name="item_id">
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Назад</button>
                            <button type="submit" class="btn btn-danger">Удалить</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%
            User currentUseruser = (User) session.getAttribute("currentUser");
            if (user != null){
        %>
        <form action="/add-comment" method="post">
        <label><%=currentUseruser.getFullName()%></label>
            <input type="hidden" value="<%=item.getId()%>" name="items_id">
        <textarea name="description" class="form-control" rows="5"></textarea>
        <button class="btn btn-primary">ADD COMMENT</button>
        </form>
        <%
            List<Comment>comments = (List<Comment>) request.getAttribute("comments");
            for (Comment comment : comments){
        %>
        <div style="display: flex; justify-content: space-between">
            <div>
        <label ><%=comment.getUser().getFullName()%> add comment at <%=comment.getPostDate()%></label>
        <p><%=comment.getDescription()%></p>
            </div>
            <div>
                <%
                    if(comment.getUser().getId().equals(user.getId())){
                %>
                <form action="/delete-comment" method="post">
                    <input type="hidden" value="<%=item.getId()%>" name="item_id">
                    <input type="hidden" value="<%=comment.getId()%>" name="comment_id">
                    <button class="btn btn-danger">X</button>
                </form>
                <%
                    }
                %>
            </div>
        </div>
        <%
            }
        %>
        <%
            }
        %>
        <%
            }
        %>

    </div>
    </div>
</div>
</body>
</html>
