/**
 * 
 * ===============================================================
 * fevvelasquez 2021, Building a website without using a framework, from 
 * JAVA WEB DEVELOPMENT UNDER THE HOOD Course at Virtual Pair Programmers.
 * ===============================================================
 * 
 * 
 * 
 * This program is free software: 
 * you can redistribute and/or modify it under the terms of 
 * GNU General Public License as published by the 
 * Free Software Foundation. <http://www.gnu.org/licenses/>
 * 
 */
package me.fevvelasquez.jwuth.restaurant.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.fevvelasquez.jwuth.restaurant.data.MenuDataService;
import me.fevvelasquez.jwuth.restaurant.domain.MenuItem;

@SuppressWarnings("serial")
public class OrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Process order
		Function<MenuItem, BigDecimal> itemPriceMultipliedByQuantity = 
				menuItem -> menuItem.getPrice().multiply(
						new BigDecimal(request.getParameter("qOf_" + menuItem.getId()))
					);
		// ---------------------------------------------------------------
		MenuDataService mds = new MenuDataService();
		BigDecimal total = mds.getFullMenu().stream()
				.map(itemPriceMultipliedByQuantity)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		// ---------------------------------------------------------------
		
		// Post-Redirect-Get
		response.sendRedirect("order?total=" +total);
		// ---------------------------------------------------------------

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters
		String total = request.getParameter("total");
		// ---------------------------------------------------------------
		
		// Build html text
		StringBuilder html = new StringBuilder();
		// ---------------------------------------------------------------
		html.append("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "  <head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <title>Restaurant</title>\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "	   <h1>Restaurant</h1>\n");		
		// ---------------------------------------------------------------
		html.append("<h2>Order Received.</h2>\n");
		html.append("<p>Your order has been received. <br> The total is "
				+ NumberFormat.getCurrencyInstance(Locale.UK).format(new BigDecimal(total)) 
				+ "</p>\n");
		// ---------------------------------------------------------------
		html.append("</body>\n"
				+"</html>");
		// ---------------------------------------------------------------

		
		
		// Write and send response
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print(html);
		out.close();
		// ---------------------------------------------------------------
	}
}
