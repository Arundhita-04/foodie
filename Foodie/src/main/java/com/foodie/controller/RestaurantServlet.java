package com.foodie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.food.dao.RestaurantDAO;
import com.foodie.daoimplemention.RestaurantDAOImp;
import com.foodie.model.Restaurant;

/**
 * Servlet implementation class Restaurant
 */
@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	RestaurantDAO restaurantDao;
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	restaurantDao = new RestaurantDAOImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Restaurant> restaurantList = restaurantDao.getAllRestaurant();
//		System.out.println(restaurantList);
//		HttpSession session = request.getSession();
//		session.setAttribute("restaurantList", restaurantList);
//		
		request.setAttribute("restaurantList", restaurantList);
		System.out.println("req working");
		
		RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
