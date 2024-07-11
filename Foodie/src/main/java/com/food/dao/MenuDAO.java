package com.food.dao;

import java.util.List;

import com.foodie.model.Menu;

public interface MenuDAO {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenuByRestaurant();
	List<Menu> getAllMenuByRestaurantId(int restaurantId);
}
