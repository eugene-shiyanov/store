package org.store.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;
import org.store.models.Store;
import org.store.validation.AbstractValidator;
import org.store.validation.StoreValidator;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/storeEdit.do")
public class StoreEditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, NumberFormatException {
        Store store;

        if (request.getParameter("id") != null) {
            Long id = Long.parseLong(request.getParameter("id"));
            StoreDao storeDao = new StoreDao();
            store = storeDao.getById(id);
        } else {
            store = new Store();
        }

        request.setAttribute("store", store);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/storeEdit.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, NumberFormatException {
        StoreDao storeDao = new StoreDao();
        Long id = null;

        if ((request.getParameter("id") != null) && !request.getParameter("id").isEmpty()) {
            id = Long.parseLong(request.getParameter("id"));
        }

        String name = request.getParameter("name");
        Store store = new Store();
        store.setId(id);
        store.setName(name);
        AbstractValidator validator = new StoreValidator();
        validator.validate(store);

        if (validator.hasErrors()) {
            request.setAttribute("store", store);
            request.setAttribute("errors", validator.getErrorMessages());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/storeEdit.jsp");
            dispatcher.forward(request, response);
        } else {
            storeDao.saveOrUpdate(store);
            response.sendRedirect("stores.do");
        }
    }

}
