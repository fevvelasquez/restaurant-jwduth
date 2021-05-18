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
package me.fevvelasquez.jwuth.restaurant.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import me.fevvelasquez.jwuth.restaurant.domain.MenuItem;

/**
 * Represents the Menu list of available food items.
 */
public class MenuDataService {
	
	private List<MenuItem> menuItems;
	{
		menuItems = new ArrayList<MenuItem>();

		menuItems.add(new MenuItem(1, "Soup of the day", 4.99,
				"A delicious soup made from the chef's choice of vegetables. Served with a home baked bread roll."));
		menuItems.add(new MenuItem(2, "Asparagus filo parcels", 6.99,
				"Fresh seasonal asparagus, wrapped in a light filo pastry, served with a chilli dipping sauce."));
		menuItems.add(new MenuItem(3, "Chicken Terrine", 5.99,
				"Our terrine tastes of summer! We use only the finest organic chicken. Served with a mixed leaf salad. (contains nuts)"));
		menuItems.add(new MenuItem(4, "Lamb Shank", 12.99,
				"Slow cooked to perfection, our organic lamb melts in the mouth. Served with mixed vegetables and seasonal potatoes."));
		menuItems.add(new MenuItem(5, "Sea Bass", 11.99,
				"We pan fry our freshly caught sea bass to seal in the flavour. Served with mixed vegetables and seasonal potatoes."));
		menuItems.add(new MenuItem(6, "Butternut squash risotto", 9.99,
				"People come from far and wide for our famous risotto. Served with a mixed leaf salad."));
		menuItems.add(new MenuItem(7, "Raspberry cheesecake", 6.99,
				"A delightfully sweet cheesecake, served with a sour raspberry compot, to form a perfect balance to end your meal."));
		menuItems.add(new MenuItem(8, "Lemon mousse", 6.99,
				"Feeling full? Our mousse is delightfully light and fluffy. Served with home baked shortbread."));
		menuItems.add(new MenuItem(9, "Fruit skewers", 6.99,
				"Our nostalgic 80s desert is super healthy... then we add luxurious vanilla ice-cream and chocolate sauce. "));
		menuItems.add(
				new MenuItem(10, "Coffee", 2.99, "Espresso, Americano, Latte or Capuccino? Tell us how you like it!"));
		menuItems.add(new MenuItem(11, "Tea", 2.99, "We have a full range of classic and herbal teas."));
	}

	public List<MenuItem> getFullMenu() {
		return menuItems;
	}
	
	public List<MenuItem> getMenuListContaining(String searchFor) {
		String charSequenceLowerCase = searchFor.toLowerCase();
		Predicate<MenuItem> nameContains = menuItem -> menuItem.getName().toLowerCase()
				.contains(charSequenceLowerCase);
		Predicate<MenuItem> descriptionContains = menuItem -> menuItem.getDescription().toLowerCase()
				.contains(charSequenceLowerCase);
		return menuItems.stream().filter(nameContains.or(descriptionContains)).collect(Collectors.toList());

	}

}
