package org.store.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.StoreDao;

@SuppressWarnings("serial")
public class StoreRemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		Long id = Long.parseLong(request.getParameter("id"));
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		StoreDao storeDao = new StoreDao(conn);
		storeDao.removeById(id);
		response.sendRedirect("stores.do");
	}
}	
