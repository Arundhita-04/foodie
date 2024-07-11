package com.foodie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.UserDAO;
import com.foodie.daoimplemention.UserDAOImp;
import com.foodie.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// creating user object whenever the RegisterationServlet is called
    	userDao = new UserDAOImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//We can use doGet() or doPost() if we want to
		String username,password,cpassword,email,address,role;
	
		username = req.getParameter("username");
		password = req.getParameter("password");
		cpassword = req.getParameter("cpassword");
		email = req.getParameter("email");
		address = req.getParameter("address");
		role = req.getParameter("role");
		
		if(password.equals(cpassword))
		{
			int x = userDao.addUser(new User(username,password,email,address,role));
			//here we are giving an user object to the addUser method with the help of the constructor
			if(x != 0)
			{
				resp.sendRedirect("login.jsp");
				
			}
			else {
				
				resp.sendRedirect("failureRegistration.jsp");
			}
			
		}
		else {
			resp.sendRedirect("passwordError.jsp");
			
		}
		
		
	}

}
