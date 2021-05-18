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
package me.fevvelasquez.jwuth.restaurant.domain;

import java.math.BigDecimal;

/**
 * Represents a food item within the Restaurant Menu.
 */
public class MenuItem {
	private int id;
	private String name;
	private BigDecimal price;
	private String description;

	public MenuItem(int id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = BigDecimal.valueOf(price);
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
