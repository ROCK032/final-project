package Servlets;

import db.DBManager;
import models.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        List<Item> items = dbManager.getItems();
        req.setAttribute("items", items);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        dbManager.closeConnection();
    }
}

