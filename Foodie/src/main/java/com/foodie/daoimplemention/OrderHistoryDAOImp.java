package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.food.dao.OrderHistoryDAO;
import com.foodie.model.OrderHistory;

public class OrderHistoryDAOImp implements OrderHistoryDAO {
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `order_history`(`status`, `order_date`, `total_amount`) VALUES(?,?,?)";
	String deleteQuery = "DELETE FROM `order_history` WHERE `order_history_id` = ?";
	String selectQuery = "SELECT * FROM `order_history`";
	String retreiveQuery ="SELECT * FROM `order_history` WHERE `order_history_id` = ?";
	String updateQuery = "UPDATE `order_history` SET `status`=?, `order_date`=?, `total_amount`=? WHERE `order_history_id`=?";
	PreparedStatement statement = null;
	OrderHistory orderHistory = null;
	ResultSet res = null; 
	
	
	

	public OrderHistoryDAOImp() 
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
	public void addOrderHistory(OrderHistory orderHistory) {
		try 
		{
			statement = connection.prepareStatement(insertionQuery);
			statement.setString(1,orderHistory.getStatus());
			statement.setDate(2, new Date(orderHistory.getOrderDate().getTime()));
			statement.setDouble(3, orderHistory.getTotalAmount());
			
			System.out.println("Rows affected: "+ statement.executeUpdate());
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		try {
		statement = connection.prepareStatement(retreiveQuery);
		statement.setInt(1, orderHistoryId);
		res = statement.executeQuery();
		while(res.next())
		{
			orderHistory = extractFromResultSet(res);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderHistory;
	}
	
	private OrderHistory extractFromResultSet(ResultSet res)
	{
		
		OrderHistory orderHistory = new OrderHistory();
		
		try {
			
			orderHistory.setOrderHistoryId(res.getInt("order_history_id"));
			orderHistory.setOrderId(res.getInt("order_id"));
			orderHistory.setUserId(res.getInt("user_id"));
			orderHistory.setStatus(res.getString("status"));
			orderHistory.setOrderDate(res.getDate("order_date"));
			orderHistory.setTotalAmount(res.getDouble("total_amount"));
		
		
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderHistory;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		try 
		{	
			statement = connection.prepareStatement(updateQuery);
			
//			statement.setInt(2, order.getUserId());
//			statement.setInt(3, order.getResturantId());
			statement.setString(1, orderHistory.getStatus());
			statement.setDate(2, new Date(orderHistory.getOrderDate().getTime()));
			statement.setDouble(3, orderHistory.getTotalAmount());
			statement.setInt(4, orderHistory.getOrderId());
			
			System.out.println("row affected " + statement.executeUpdate());
			
			
			
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
