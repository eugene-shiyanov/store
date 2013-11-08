package org.store.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.ItemDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/itemRemove.do")
public class ItemRemoveServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {
        Long id = Long.parseLong(request.getParameter("id"));
        ItemDao itemDao = new ItemDao();
        itemDao.removeById(id);
        response.sendRedirect("items.do");
    }
}
