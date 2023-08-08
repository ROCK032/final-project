package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet("/people")
public class PeopleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            req.getRequestDispatcher("/people.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/signin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("user_id"));
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String fullName = req.getParameter("user_full_name");
        User user = DBManager.getUserById(id);
        if (user != null) {
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(fullName);
        }
        DBManager.peopleUser(user);

        // После успешного обновления профиля, обновляем данные пользователя в сессии
        req.getSession().setAttribute("currentUser", user);

        // Перенаправляем на страницу /people для отображения изменений
        resp.sendRedirect("/people");
    }
}
