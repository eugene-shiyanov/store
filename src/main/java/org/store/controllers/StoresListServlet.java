package org.store.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;
import org.store.models.Store;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/stores.do")
public class StoresListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreDao storeDao = new StoreDao();
        List<Store> stores = storeDao.getAll();
        request.setAttribute("stores", stores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/stores.jsp");
        dispatcher.forward(request, response);
    }
}