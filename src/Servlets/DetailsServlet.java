package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Item;
import models.User;


import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Item item = DBManager.getItem(id);
        req.setAttribute("danne", item);
        User user = (User) req.getSession().getAttribute("currentUser");
        if (user != null){
            req.setAttribute("comments", DBManager.getCommentsByItemId(id));
            req.getRequestDispatcher("details.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        }
    }
}



