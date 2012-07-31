package org.store.listeners;

import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class ApplicationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		/*String url = ctx.getInitParameter("db_url");
		String user = ctx.getInitParameter("db_user");
		String pass = ctx.getInitParameter("db_pass");*/
		String url = "jdbc:mysql://localhost:3306/store";
		String user = "root";
		String pass = "yjc";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("create table if not exists Items");
			sb.append(" (");
			sb.append("item_id bigint auto_increment primary key,");
			sb.append(" name char(255) not null,");
			sb.append(" price double");
			sb.append(")");
			String query = sb.toString();
			stat.executeUpdate(query);
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
