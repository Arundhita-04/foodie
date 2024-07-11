package com.foodie.daoimplemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.UserDAO;
import com.foodie.model.User;

public class UserDAOImp implements UserDAO{
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertionQuery = "INSERT INTO `user`(user_id,user_name, password, email, address, role)"+ "VALUES(?,?,?,?,?,?)";
	String deleteQuery = "DELETE FROM `user` WHERE `user_id` = ?";
	String selectQuery = "SELECT * FROM `user`";
	String retreiveQuery ="SELECT * FROM `user` WHERE `email` = ?";
	String updateQuery = "UPDATE `user` SET user_name = ? ,password = ?,email=?,address=?,role=? WHERE user_id=?";
	PreparedStatement statement = null;
	User user;
	public UserDAOImp()
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
	public int addUser(User user) {
		// TODO Auto-generated method stub
		try {
			statement= connection.prepareStatement(insertionQuery);
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getRole());
			return statement.executeUpdate();
			//here we are returning int value to check the user added is successfull or not 
		
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public User getUser(String email) {
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setString(1,email);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				user = extractUserFromResultSet(res);
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		
	}		
		return user;	
		}
	
	
	private User extractUserFromResultSet(ResultSet res) throws SQLException
	{
		User user = new User();
		user.setUserId(res.getInt("user_id"));
		user.setUsername(res.getString("user_name"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		
		return user;
	}
	

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			statement= connection.prepareStatement(updateQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getRole());
			statement.setInt(6, user.getUserId());
			
			statement.executeUpdate();
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void deleteUser(int userId) {
		try 
		{
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, userId);
			statement.executeUpdate();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

	@Override
	public List<User> getAllUser() {
		List<User> al = new ArrayList<User>();
		try
		{
			statement = connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				user = extractUserFromResultSet(res);
				al.add(user);
				
			}
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return al;
		
		
	}
	

}
