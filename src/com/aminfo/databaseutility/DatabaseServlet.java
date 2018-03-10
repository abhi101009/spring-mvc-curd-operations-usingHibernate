package com.aminfo.databaseutility;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup database connection variables
		String dbUsername = "springstudent";
		String dbPassword = "springstudent";
		
		String jdbcDBUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driverName = "com.mysql.jdbc.Driver";
		
		// get connection to database
		Connection con = null;
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: "+ jdbcDBUrl);
			
			Class.forName(driverName);
			con = DriverManager.getConnection(jdbcDBUrl, dbUsername,dbPassword);
			out.println("Database connected successfully!!!");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
