package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDAO;
import com.foodie.model.OrderItem;

public class OrderItemDAOImp implements OrderItemDAO
{
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `order_item`(`quantity`,`item_total`) VALUES(?,?)";
	String deleteQuery = "DELETE FROM `order_item` WHERE `order_item_id` = ?";
	String selectQuery = "SELECT * FROM `order_item`";
	String retreiveQuery ="SELECT * FROM `order_item` WHERE `order_item_id` = ?";
	String updateQuery = "UPDATE `order_item` SET `quantity = ?`, `item_total =?` WHERE `order_item_id`=?";
	PreparedStatement statement = null;
	OrderItem orderItem = null;
	ResultSet res = null; 

	public OrderItemDAOImp() {
		super();
		// TODO Auto-generated constructor stub
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
	public void addOrder(OrderItem orderItem) {
		// TODO Auto-generated method stub
		try 
		{
			statement = connection.prepareStatement(insertionQuery);
			statement.setInt(1,orderItem.getQuantity());
			statement.setDouble(2, orderItem.getItemTotal());
			System.out.println("Rows affected: "+ statement.executeUpdate());
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderItem getOrder(int orderItemId) {
		
		try 
		{
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, orderItemId);
			res = statement.executeQuery();
			while(res.next())
			{
				orderItem = extractUserFromResultSet(res);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderItem;
	}
	private OrderItem extractUserFromResultSet(ResultSet res) throws SQLException
	{
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(res.getInt("order_item_id"));
		orderItem.setOrderId(res.getInt("order_id"));
		orderItem.setMenuId(res.getInt("menu_id"));
		orderItem.setQuantity(res.getInt("quantity"));
		orderItem.setItemTotal(res.getDouble("item_total"));
		
		return orderItem;
		}
		
//		return user;
//	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		try 
		{
			statement = connection.prepareStatement(updateQuery);
			statement.setInt(1,orderItem.getQuantity());
			statement.setDouble(2,orderItem.getItemTotal());
			statement.setInt(3,orderItem.getOrderItemId());
			
			
			System.out.println("Rows effected: " + statement.executeUpdate());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		try 
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, orderItemId);
			System.out.println(statement.executeUpdate());
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	@Override
	public List<OrderItem> getAllOrderItemByUser() {
		ArrayList a = new ArrayList();
		
		try 
		{
			statement = connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			
			while(res.next())
			{
				orderItem = extractUserFromResultSet(res);
				a.add(orderItem);
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
		
	}
	

	
	
	
}
