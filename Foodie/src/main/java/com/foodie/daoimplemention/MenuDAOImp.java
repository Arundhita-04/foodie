package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDAO;
import com.foodie.model.Menu;

public class MenuDAOImp implements MenuDAO
{
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `menu`(`menu_id`,`item_name`, `price`, `is_available`) VALUES(?,?,?,?)";
	String deleteQuery = "DELETE FROM `menu` WHERE `menu_id` = ?";
	String selectQuery = "SELECT * FROM `menu`";
	String retreiveQuery ="SELECT * FROM `menu` WHERE `menu_id` = ?";
	String updateQuery = "UPDATE `menu` SET `item_name`=?, `description`=?, `price`=?, `is_available`=? WHERE `menu_id`=?";
	PreparedStatement statement = null;
	Menu menu = null;
	String menuByResId = "SELECT * FROM `menu` WHERE `restaurant_id` =?";
	
	
	public MenuDAOImp() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);

		} 
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(insertionQuery);
			
			statement.setInt(1,menu.getMenuId());
			statement.setString(2,menu.getItemName());
			statement.setDouble(3,menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			
			
			System.out.println("row affected " + statement.executeUpdate());		
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public Menu getMenu(int menuId) {
		// TODO Auto-generated method stub
		try {
		statement = connection.prepareStatement(retreiveQuery);
		statement.setInt(1, menuId);
		ResultSet res = statement.executeQuery();
		if(res.next())
		{
			menu = extractFromResultSet(res);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return menu;
	}
	
	
	private Menu extractFromResultSet(ResultSet res)
	{
		
		try
		{
			Menu menu = new Menu();
			menu.setResturantId(res.getInt("restaurant_id"));
			menu.setItemName(res.getString("item_name"));
			menu.setDescription(res.getString("description"));
			menu.setPrice(res.getDouble("price"));
			menu.setAvailable(res.getBoolean("is_available"));
			
			
			return menu;
			 
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu;
		
	}
	
	
	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1,menu.getItemName());
			statement.setString(2, menu.getDescription());
			statement.setDouble(3, menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			statement.setInt(5, menu.getMenuId());
			System.out.println("Rows effected: " + statement.executeUpdate());
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void deleteMenu(int menuId) {
		try 
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, menuId);
			System.out.println("row effected: " + statement.executeUpdate());
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Menu> getAllMenuByRestaurant() {
		// TODO Auto-generated method stub
		ArrayList <Menu>al = new ArrayList<Menu>();
		try 
		{
			statement = connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				menu = extractFromResultSet(res);
				al.add(menu);
			}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public List<Menu> getAllMenuByRestaurantId(int restaurantId) {
		ArrayList <Menu> al = new ArrayList<Menu>();
		
		try {
			statement = connection.prepareStatement(menuByResId);
			statement.setInt(1, restaurantId);
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				menu = extractFromResultSet(res);
				al.add(menu);
			}
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	
	
	
}
