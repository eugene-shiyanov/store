package org.store.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.ItemDao;
import org.store.models.Item;
import org.store.validation.ItemValidator;

@SuppressWarnings("serial")
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
		Double price = null;
		try {
		    price = Double.parseDouble(request.getParameter("price"));
		} catch (NumberFormatException ex) {
		}
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		item.setPrice(price);
		ItemValidator validator = new ItemValidator();
		validator.validate(item);
		if (validator.hasErrors()) {
		    request.setAttribute("item", item);
		    request.setAttribute("errors", validator.getErrorMessages());
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/itemEdit.jsp");
		    dispatcher.forward(request, response);
		} else {
		    itemDao.saveOrUpdate(item);
		    response.sendRedirect("items.do");		
		}
	}
}