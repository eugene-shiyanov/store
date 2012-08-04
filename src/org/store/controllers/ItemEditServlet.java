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
		Long id = Long.parseLong(request.getParameter("id"));
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		ItemDao itemDao = new ItemDao(conn);
		Item item = itemDao.getById(id);
		request.setAttribute("item", item);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/itemEdit.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException, NumberFormatException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		ItemDao itemDao = new ItemDao(conn);
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		item.setPrice(price);
		itemDao.update(item);
		//List<Item> items = itemDao.getAll();
		//request.setAttribute("items", items);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/items.jsp");
		//dispatcher.forward(request, response);
		response.sendRedirect("/store/items.do");		
	}
}
