package org.store.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.store.dao.ItemDao;

@SuppressWarnings("serial")
public class ItemRemoveServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, NumberFormatException {
			Long id = Long.parseLong(request.getParameter("id"));
			ServletContext ctx = getServletContext();
			Connection conn = (Connection) ctx.getAttribute("conn");
			ItemDao itemDao = new ItemDao(conn);
			itemDao.removeById(id);
			response.sendRedirect("items.do");
		}
}
