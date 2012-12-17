package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

import org.store.dao.ItemDao;
import org.store.models.Item;

public class ItemsListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		ItemDao itemDao = new ItemDao(conn);
		List<Item> items = itemDao.getAll();
		request.setAttribute("items", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/items.jsp");
		dispatcher.forward(request, response);
	}
}
