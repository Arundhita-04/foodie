package com.foodie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.UserDAO;
import com.foodie.daoimplemention.UserDAOImp;
import com.foodie.model.User;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDao;
	
	@Override
		public void init() throws ServletException {
			userDao = new UserDAOImp();
		}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userDao = new UserDAOImp();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User loggedInUser = userDao.getUser(email);
		System.out.println("working");
		if(loggedInUser.getPassword() != null && password.equals(loggedInUser.getPassword()))
		{
			//put details into the session here we are creating the session for the first time thats why we set it as true 
		
			HttpSession session = req.getSession();
			//storing the user object into the session
			session.setAttribute("userDao", loggedInUser);
			resp.sendRedirect("index.jsp");
//			if(loggedInUser.getRole().equals("USER"))
//			{
//			}
//			
		}
		
		else {
			req.setAttribute("errorMessage","Invalid username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}		
	}
}
