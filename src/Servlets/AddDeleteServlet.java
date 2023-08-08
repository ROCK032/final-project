package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-comment")
public class AddDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Получаем параметры comment_id и item_id из запроса
            Long commentId = Long.parseLong(req.getParameter("comment_id"));
            Long itemId = Long.parseLong(req.getParameter("item_id"));

            // Удаляем комментарий по его идентификатору
            DBManager.deleteCommentById(commentId);

            // Перенаправляем пользователя обратно на страницу с деталями предмета
            resp.sendRedirect(req.getContextPath() + "/details?id=" + itemId);
        } catch (Exception e) {
            e.printStackTrace();
            // Здесь можно добавить обработку ошибок, если что-то пошло не так
            // Например, перенаправить пользователя на страницу с ошибкой
            resp.sendRedirect(req.getContextPath() + "/error-page");
        }
    }
}

