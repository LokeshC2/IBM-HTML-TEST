package com.example.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			ServletContext context = getServletContext();
			try (InputStream iStream = context.getResourceAsStream("/WEB-INF/data.csv")) {
				try (InputStreamReader isReader = new InputStreamReader(iStream)) {
					try (BufferedReader br = new BufferedReader(isReader)) {
						try (PrintWriter out = response.getWriter()) {
							String line;
							out.println("<html><body>");
							out.println("<table border=1>");
							out.println("<tr><th>Id</th><th>Name</th><th>Price</th></tr>");
							while ((line = br.readLine()) != null) {
								String[] values = line.split(",");
								out.println("<tr>");
								for (String str : values) {
									out.println("<td>" + str + "</td>");
								}
								out.println("</tr>");
							}
							out.println("</table>");
							out.println("<a href='index.html'>Add New Product</a>");
							out.println("</body></html>");
						}
					}
				}
			}
			response.setStatus(200);
		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
			response.setStatus(500);
		}
	}
}
