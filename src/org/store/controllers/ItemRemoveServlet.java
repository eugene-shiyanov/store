package org.store.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import org.store.dao.ItemDao;

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
