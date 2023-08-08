package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Item;

import java.io.IOException;

@WebServlet(value = "/edit-task")
public class EditItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("item_id"));
        String name = req.getParameter("item_name");
        String description = req.getParameter("item_description");
        String price = req.getParameter("item_price");
        String specification = req.getParameter("item_specification");
        Item item= DBManager.getItemById(id);
        if (item!=null){
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            item.setSpecification(specification);
        }
        DBManager.editItem(item);
        resp.sendRedirect("/details?id="+id);
    }
}
