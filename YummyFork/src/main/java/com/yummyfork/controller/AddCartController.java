package com.yummyfork.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyfork.dto.Customer;

@WebServlet("/AddCartController")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddCartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch record from repository 
		//use setAttribute method
		//dispatch response to ShowCart.jsp
		
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("username");	
		
		System.out.println("userEmail...>"+userEmail);
		
		Customer c=new Customer();
		c.getCustId();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
