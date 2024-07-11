package com.food.dao;

import java.util.List;

import com.foodie.model.User;

public interface UserDAO {
	int addUser(User user);
	User getUser(String email);
	void updateUser(User use);
	void deleteUser(int userId);
	List<User> getAllUser();
	
	
}
