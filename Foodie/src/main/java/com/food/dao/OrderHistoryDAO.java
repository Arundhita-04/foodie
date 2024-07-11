package com.food.dao;

import java.util.List;

import com.foodie.model.OrderHistory;

public interface OrderHistoryDAO {
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getAllOrderHistory();
}
