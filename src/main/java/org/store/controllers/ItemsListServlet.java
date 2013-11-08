package org.store.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.ItemDao;
import org.store.models.Item;

@SuppressWarnings("serial")
public class ItemsListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDao itemDao = new ItemDao();
        List<Item> items = itemDao.getAll();
        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/items.jsp");
        dispatcher.forward(request, response);
    }
}
