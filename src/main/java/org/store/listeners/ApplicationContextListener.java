package org.store.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		String url = ctx.getInitParameter("db_url");
		String user = ctx.getInitParameter("db_user");
		String pass = ctx.getInitParameter("db_pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			ctx.setAttribute("conn", conn);
		} catch (SQLException ex) {
			System.out.println("can't set the connection");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("can't find driver's class");
			System.out.println(ex.getMessage());
		}
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
