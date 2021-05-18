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
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.fevvelasquez.jwuth.restaurant.data.MenuDataService;
import me.fevvelasquez.jwuth.restaurant.domain.MenuItem;

@SuppressWarnings("serial")
public class MenuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Build html text
		StringBuilder html = new StringBuilder();
		// ---------------------------------------------------------------
		html.append("<html>");
		html.append("<head></head>");
		html.append("<body>");
		html.append("<h1>Menu</h1><ul>");
		// ---------------------------------------------------------------
		MenuDataService mds = new MenuDataService();
		List<MenuItem> menu = mds.getFullMenu();
		menu.stream().forEach(item -> 
			html.append(
				"<li>" + item.getName().toUpperCase() +
					"<br>" + item.getDescription() +
					"<br>" + NumberFormat.getCurrencyInstance(Locale.UK).format(item.getPrice()) +
					"<br>" +
				"</li>")
			);
		// ---------------------------------------------------------------
		html.append("</ul></body>");
		html.append("</html>");
		// ---------------------------------------------------------------

		// Write and send response
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print(html);
		out.close();
		// ---------------------------------------------------------------
	}

}
