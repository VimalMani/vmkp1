package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public logincontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		String UserID=request.getParameter("UserID");
		String password=request.getParameter("password");
		LoginDAO loginDAO=new LoginDAO();
		RequestDispatcher dispatcher;
		
		if(( loginDAO).isValidUser(UserID, password) == true){
			//navigate to home page
			System.out.println("success");
			dispatcher=request.getRequestDispatcher("home.html");
			dispatcher.forward(request,response);
		}
		else
		{
			//navigate to login page itself with error message
			dispatcher=request.getRequestDispatcher("Login1.html");
			PrintWriter writer=response.getWriter();
			writer.append("Invalid credentials....please try again");
			dispatcher.include(request,response);
		}
	}
		
		
	}


