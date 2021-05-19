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
		html.append("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "  <head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <title>Restaurant</title>\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "	   <h1>Restaurant</h1>\n");	
		// ---------------------------------------------------------------
		MenuDataService mds = new MenuDataService();
		List<MenuItem> menu = mds.getFullMenu();

		html.append("<h2>Full Menu:</h2>\n");
		html.append("<form action=\"order\" method=\"post\">\n");
		html.append("<ul>\n");
		menu.stream().forEach(menuItem -> 
			html.append(
				  "<li>\n" + menuItem.getName().toUpperCase()
				+ " <input type=\"number\" min=\"0\" max=\"10\" value=\"0\" name=\"qOf_"+ menuItem.getId() +"\"> &#127860;" 
				+	"<br>" + menuItem.getDescription()
				+	"<br>" + NumberFormat.getCurrencyInstance(Locale.UK).format(menuItem.getPrice()) + "\n"
				+ "</li>\n")
			);
		html.append("</ul>\n");
		html.append("<input type=\"submit\" value=\"Place order\">\n");
		html.append("</form>\n");
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
