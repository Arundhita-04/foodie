package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderDAO;
import com.foodie.model.Order;

public class OrderDAOImp implements OrderDAO{
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `order`(`order_date`, `total_amount`, `status`, `payment_method`) VALUES(?,?,?,?)";
	String deleteQuery = "DELETE FROM `order` WHERE `order_id` = ?";
	String selectQuery = "SELECT * FROM `order`";
	String retreiveQuery ="SELECT * FROM `order` WHERE `order_id` = ?";
	String updateQuery = "UPDATE `order` SET `order_date`=?, `total_amount`=?, `status`=?, `payment_method`=? WHERE `order_id`=?";
	PreparedStatement statement = null;
	Order order = null;
	ResultSet res = null; 
	
	public OrderDAOImp() {
		super();
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
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		try 
		{
			statement = connection.prepareStatement(insertionQuery);
			statement.setDate(1, new Date(order.getOrderDate().getTime()));
			statement.setDouble(2,order.getTotalAmount());
			statement.setString(3, order.getStatus());
			statement.setString(4, order.getPaymentMethod());
			
			System.out.println("Rows affected: "+ statement.executeUpdate());
			
		} 
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	
	@Override
	public Order getOrder(int orderId) {
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, orderId);
			res = statement.executeQuery();
			while(res.next())
			{
				order = extractFromOrderResultSet(res);
			}
			
		} 
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

	private Order extractFromOrderResultSet(ResultSet res) throws SQLException{
		
		Order order = new Order();
		order.setOrderId(res.getInt("order_id"));
		order.setUserId(res.getInt("user_id"));
		order.setResturantId(res.getInt("restaurant_id"));
		order.setOrderDate(res.getDate("order_date"));
		order.setTotalAmount(res.getDouble("total_amount"));
		order.setStatus(res.getString("status"));
		order.setPaymentMethod(res.getString("payment_method"));
		
		return order;
		
		
	}
	
	
	@Override
	public void updateOrder(Order order) {
		try 
		{	
			statement = connection.prepareStatement(updateQuery);
			
//			statement.setInt(2, order.getUserId());
//			statement.setInt(3, order.getResturantId());
			statement.setDate(1, new Date(order.getOrderDate().getTime()));
			statement.setDouble(2, order.getTotalAmount());
			statement.setString(3, order.getStatus());
			statement.setString(4, order.getPaymentMethod());
			statement.setInt(5, order.getOrderId());
			
			System.out.println("row affected " + statement.executeUpdate());
			
			
			
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrder(int orderId) {
		try 
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, orderId);
			System.out.println(statement.executeUpdate());
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement(selectQuery);
		
		ResultSet res = statement.executeQuery();
		
		while(res.next())
		{
			order = extractFromOrderResultSet(res);
			al.add(order);
		}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al ;
	}
	
}
