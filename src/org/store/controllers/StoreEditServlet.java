package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.store.dao.*;
import org.store.models.*;

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
