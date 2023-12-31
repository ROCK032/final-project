package Servlets;

import db.DBManager;
import models.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private DBManager dbManager;

    @Override
    public void init() throws ServletException {
        super.init();
        dbManager = new DBManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        if (user != null){
            req.setAttribute("items", DBManager.getItems());
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("signin.jsp").forward(req, resp);

    }
}

