package com.food.main;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.foodie.daoimplemention.OrderItemDAOImp;
import com.foodie.model.OrderItem;

public class Launch {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		
		
//		//GET ALL THE ORDER ITEM
//		OrderItemDAOImp od = new OrderItemDAOImp();
//		List<OrderItem> al = od.getAllOrderItemByUser();
//		for(OrderItem o : al)
//		{
//			System.out.println(o);
//		}
//		
		//DELETE ORDER ITEM
		OrderItemDAOImp od = new OrderItemDAOImp();
		od.deleteOrderItem(2);
		
//		//UPDATE ORDER ITEM
//		
//		OrderItem o = new OrderItem(2,0, 0,3, 600.0);
//		OrderItemDAOImp od = new OrderItemDAOImp();
//		od.updateOrderItem(o);
//		
//		//GET ORDERITEM
//		OrderItemDAOImp orderItemDAOImp = new OrderItemDAOImp();
//		OrderItem orderItem = orderItemDAOImp.getOrder(1);
//		System.out.println(orderItem);
//		
		
//		//ADD ORDER ITEMS
//		OrderItemDAOImp orderItemDAOImp = new OrderItemDAOImp();
//		OrderItem oI = new OrderItem(1, 0, 0, 2, 300.0);
//		orderItemDAOImp.addOrder(oI);
//		
//		
//		//UPDATE ORDER HISTORY
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		OrderHistory od = new OrderHistory(1,"Order History",format.parse("2024-10-03"),250.0);
//		OrderHistoryDAOImp orderHistoryDAOImp = new OrderHistoryDAOImp();
//		orderHistoryDAOImp.updateOrderHistory(od);
//		
	
		
		
//		//GET ORDER HISTORY
//		OrderHistoryDAOImp orderHistory = new OrderHistoryDAOImp();
//		OrderHistory od = orderHistory.getOrderHistory(1);
//		System.out.println(od);
//		
//		
//		
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		OrderHistoryDAOImp od = new OrderHistoryDAOImp();
//		OrderHistory oH = new OrderHistory(1, 2, 1, format.parse("2024-10-03"), 299, "Delivery Time");
//		od.addOrderHistory(oH);
//		
		
		
		
//		//FETCH ALL MENU ITEMS
//		
//		MenuDAOImp md = new MenuDAOImp();
//		List<Menu> a = md.getAllMenuByRestaurant();
//		for(Menu m1 : a)
//		{
//			System.out.println(m1);
//		}
//		
//		
		
		
//		//DELETE THE MENU ITEMS
//		
//		MenuDAOImp md = new MenuDAOImp();
//		System.out.println("Enter the item_id: ");
//		md.deleteMenu(scan.nextInt());
//		
//		
//		//UPDATE THE MENU
//		Menu m= new Menu(2,"Steam momos",60.0,true);
//		MenuDAOImp md = new MenuDAOImp();
//		md.updateMenu(m);
//		
//		//GET THE VALUE FROM THE MENU TABLE
//		MenuDAOImp md = new MenuDAOImp();
//		System.out.println("Enter the menu id: ");
//		Menu menu = md.getMenu(scan.nextInt());
//		System.out.println(menu);
		
		
//		//INSERT THE VALUE IN MENU
//		Menu menu = new Menu(5,"Rajma Chawal",170.0,true);
//		MenuDAOImp md = new MenuDAOImp();
//		md.addMenu(menu);
	
//		User u = new User(0,"santosh","santosh@1243","santosh@gmail.com","Yeswantpur","customer");
//		UserDAOImp ud = new UserDAOImp();
//		ud.addUser(u);
//		
		
		
		
		//fetch the data of the user
//		UserDAOImp u =new UserDAOImp();
//		System.out.println("Enter the User Id: ");
//		User user = u.getUser(scan.nextInt());
//		System.out.println(user);
		
		
//		//update user
//		User u1 = new User(4,"rajkumar","abcd@123","abcd@gmail.com","BTM","customer");
//		
//		UserDAOImp ud = new UserDAOImp();
//		ud.updateUser(u1);
//		
//		delete row
//		UserDAOImp u = new UserDAOImp();
//		System.out.println("Enter the user id: ");
//		u.deleteUser(scan.nextInt());
//		
		
		
		
		//select all user
//		UserDAOImp u = new UserDAOImp();
//		List<User> allUsers = u.getAllUser();
//		for(User u1 : allUsers)
//		{
//			System.out.println(u1);
//		}
//		
		
//		Restaurant restaurant = new Restaurant(1,"Ghar ka khana","North-Indian",20,"BTM",4.5,true);
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		r.addRestaurant(restaurant);
//		
		
//		
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		Restaurant restaurant = r.getRestaurant(1);
//		System.out.println(restaurant);
		
//		UserDAOImp ud = new UserDAOImp();
//		User u1 = new User(4,"rajkumar","abcd@123","abcd@gmail.com","BTM","customer");
//		ud.updateUser(u1);
		
		
//		Restaurant restaurant = new Restaurant(1,"Ghar ka khana","North-Indian",20,"Patna",4.5,true);
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		r.updateRestaurant(restaurant);
		
//		//delete restaurant
//		RestaurantDAOImp r = new RestaurantDAOImp();
//		r.deleteRestaurant(1);
//		
		
		
//		RestaurantDAOImp r = new RestaurantDAOImp();
//		List<Restaurant> allRestaurants = r.getAllRestaurant();
//		for(Restaurant r1:allRestaurants)
//		{
//			System.out.println(r1);
//		}
		
		
		//Order object
		//Insert order
		
//	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////		
////		OrderDAOImp order = new OrderDAOImp();
////		Order od = new Order(3,format.parse("2024-10-03"),235.9,"Pending","DebitCard");
////		order.addOrder(od);
//		OrderDAOImp order = new OrderDAOImp();
//		//Get Orders
////		Order od = order.getOrder(1);
////		System.out.println(od);
////		
//		//Update Order
////		Order od = new Order(2,format.parse("2024-10-03"),235.9,"Pending","Cod");
////		order.updateOrder(od);
//		
////		//DELETE ORDER
////		Order od = new Order();
////		order.deleteOrder(2);
//		
//		
//		//FETCH ALL ORDERS VALUES
//		List <Order>list = order.getAllOrder();
//		for(Order o : list)
//		{
//			System.out.println(o);
//		}
//		
//	}
//
}
}
