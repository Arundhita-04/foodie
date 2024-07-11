package com.foodie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.MenuDAO;
import com.foodie.daoimplemention.MenuDAOImp;
import com.foodie.daoimplemention.RestaurantDAOImp;
import com.foodie.model.Menu;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	MenuDAO menuDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
	
	@Override
	public void init() throws ServletException {
		menuDao = new MenuDAOImp();
	}
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter will return me string value so we have to convert it into integer
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		System.out.println("menu");
		System.out.println(restaurantId);
		List<Menu> menuList= menuDao.getAllMenuByRestaurantId(restaurantId);
		request.setAttribute("menuList", menuList);
		System.out.println("menu working");
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.include(request,response);
	}
}
