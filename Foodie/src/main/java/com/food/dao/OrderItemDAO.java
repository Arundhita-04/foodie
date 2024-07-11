package com.food.dao;

import java.util.List;

import com.foodie.model.OrderItem;

public interface OrderItemDAO {
	void addOrder(OrderItem orderItem);
	OrderItem getOrder(int orderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getAllOrderItemByUser();
	
	
	
}
