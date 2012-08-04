package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.store.dao.ItemDao;
import org.store.models.Item;

public class ItemEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException, NumberFormatException {		
		Item item = null;
		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			ServletContext ctx = getServletContext();
			Connection conn = (Connection) ctx.getAttribute("conn");
			ItemDao itemDao = new ItemDao(conn);
			item = itemDao.getById(id);	
		} else {
			item = new Item();
		}
		request.setAttribute("item", item);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/itemEdit.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException, NumberFormatException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		ItemDao itemDao = new ItemDao(conn);
		Long id = null;
		if ((request.getParameter("id") != null) && !request.getParameter("id").isEmpty()) {
			id = Long.parseLong(request.getParameter("id"));	
		}
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		item.setPrice(price);
		if (item.getId() == null) {
			itemDao.save(item);
		} else {
			itemDao.update(item);
		}
		response.sendRedirect("/store/items.do");		
	}
}
