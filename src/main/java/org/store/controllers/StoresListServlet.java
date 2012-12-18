package org.store.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;
import org.store.models.Store;

@SuppressWarnings("serial")
public class StoresListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		StoreDao storeDao = new StoreDao(conn);
		List<Store> stores = storeDao.getAll();
		request.setAttribute("stores", stores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/stores.jsp");
		dispatcher.forward(request, response);
	}	
}	