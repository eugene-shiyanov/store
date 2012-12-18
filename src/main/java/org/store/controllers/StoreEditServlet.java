package org.store.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;
import org.store.models.Store;

@SuppressWarnings("serial")
public class StoreEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
		Store store = null;
		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			ServletContext ctx = getServletContext();
			Connection conn = (Connection) ctx.getAttribute("conn");
			StoreDao storeDao = new StoreDao(conn);
			store = storeDao.getById(id);
		} else {
			store = new Store();
		}
		request.setAttribute("store", store);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/storeEdit.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		StoreDao storeDao = new StoreDao(conn);
		Long id = null;
		if ((request.getParameter("id") != null) && !request.getParameter("id").isEmpty()) {
			id = Long.parseLong(request.getParameter("id"));
		}	
		String name = request.getParameter("name");
		Store store = new Store();
		store.setId(id);
		store.setName(name);
		if (store.getId() == null) {
			storeDao.save(store);
		} else {
			storeDao.update(store);
		}
		response.sendRedirect("stores.do");
	}

}
