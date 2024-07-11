package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.foodie.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO {
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `restaurant`(`name`, `cuisine_type`, `delivery_time`, `address`, `rating`, `is_active`) VALUES(?,?,?,?,?,?)";
	String deleteQuery = "DELETE FROM `restaurant` WHERE `restaurant_id` = ?";
	String selectQuery = "SELECT * FROM `restaurant`";
	String retreiveQuery ="SELECT * FROM `restaurant` WHERE `restaurant_id` = ?";
	String updateQuery = "UPDATE `restaurant` SET `name`=?, `cuisine_type`=?, `delivery_time`=?, `address`=?, `rating`=?, `is_active`=? WHERE `restaurant_id`=?";
	PreparedStatement statement = null;
	Restaurant restaurant = null;
	public RestaurantDAOImp()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		try {
			statement = connection.prepareStatement(insertionQuery);
			statement.setString(1,restaurant.getName());
			statement.setString(2,restaurant.getCusineType());
			statement.setInt(3,restaurant.getDeliveryTime());
			statement.setString(4,restaurant.getAddress());
			statement.setDouble(5,restaurant.getRating());
			statement.setBoolean(6,restaurant.isActive());
			
			
			System.out.println("row affected " + statement.executeUpdate());		
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, restaurantId);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
				
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		
		
		}
		return restaurant;
	}
	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws SQLException
	{
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(res.getInt("restaurant_id"));
		restaurant.setName(res.getString("name"));
		restaurant.setCusineType(res.getString("cuisine_type"));
		restaurant.setDeliveryTime(res.getInt("delivery_time"));
		restaurant.setAddress(res.getString("address"));
		restaurant.setAdminUserId(res.getInt("admin_user_id"));
		restaurant.setRating(res.getDouble("rating"));
		restaurant.setActive(res.getBoolean("is_active"));
		
		return restaurant;
	}

	

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		try {
			statement= connection.prepareStatement(updateQuery);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getCusineType());
			statement.setInt(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setDouble(5, restaurant.getRating());
			statement.setBoolean(6, restaurant.isActive());
			statement.setInt(7, restaurant.getRestaurantId());
			
			System.out.println("row affected " + statement.executeUpdate());
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try 
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, restaurantId);
			System.out.println(statement.executeUpdate());
			
			
			
			
		} 
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		ArrayList al = new ArrayList<>();
		
		try {
			 statement = connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
				al.add(restaurant);
				
			}
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
	}

}
