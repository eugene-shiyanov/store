package org.store.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/storeRemove.do")
public class StoreRemoveServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {
        Long id = Long.parseLong(request.getParameter("id"));
        StoreDao storeDao = new StoreDao();
        storeDao.removeById(id);
        response.sendRedirect("stores.do");
    }
}
