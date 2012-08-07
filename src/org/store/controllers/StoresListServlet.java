package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

import org.store.dao.*;
import org.store.models.*;

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