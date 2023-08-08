<%@ page import="models.User" %>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #ffffff;">
  <a class="navbar-brand" href="#" style="color: #000000;"><b>Bitlab News</b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav" style="margin-left: 80%;"> <!-- Используем инлайн стиль для выравнивания элементов по правому краю -->
      <%
        User user = (User) session.getAttribute("currentUser");
        if(user != null && user.getEmail().equals("china@gmail.com")) {

      %>
      <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addTaskModal">
        + Add news
      </button>
      <form action="/add-item" method="post">
        <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">New news</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <label>Subject:</label>
                <input name="item_name" type="text" class="form-control">
                <label class="mt-3">News:</label>
                <input name="item_specification" type="text" class="form-control">
                <label class="mt-3">Description:</label>
                <textarea name="item_description" class="form-control"></textarea>
                <label class="mt-3">Time:</label>
                <input name="item_price" type="text" class="form-control" step="any">
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Add news</button>
              </div>
            </div>
          </div>
        </div>
      </form>
      <%
        }
      %>
      <li class="nav-item">
        <a class="nav-link" href="/" style="color: #000000;">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/people" style="color: #000000;">Me</a>
      </li>
    </ul>
  </div>
</nav>





