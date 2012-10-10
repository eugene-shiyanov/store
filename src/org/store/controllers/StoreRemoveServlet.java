package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import org.store.dao.*;

public class StoreRemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		Long id = Long.parseLong(request.getParameter("id"));
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		StoreDao storeDao = new StoreDao(conn);
		storeDao.removeById(id);
		response.sendRedirect("stores.do");
	}
}	
