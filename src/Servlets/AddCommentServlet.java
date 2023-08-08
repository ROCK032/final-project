package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/add-comment")

public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Long itemId = Long.parseLong(req.getParameter("items_id"));
        User user = (User) req.getSession().getAttribute("currentUser");
        DBManager.addComment(description,itemId,user.getId());
        resp.sendRedirect("/details?id="+itemId);
    }
}
