package com.yummyfork.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yummyfork.dto.Customer;
import com.yummyfork.dto.User;
import com.yummyfork.services.CustomerService;
import com.yummyfork.services.UserService;

@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerService cs;
	
	UserService us;

  
    public AddCustomerController() {
        super();
        cs=new CustomerService(); 
        us=new UserService();
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	RequestDispatcher rd;
		PrintWriter out=response.getWriter();
		//RequestDispatcher rd;
		response.setContentType("text/html");
		
		
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		long mob=Long.parseLong(request.getParameter("mob"));
		String email=request.getParameter("mail");
		String pwd=request.getParameter("pwd");
	
		Customer c=new Customer(name,addr,mob,email);
		User u=new User(role,email,pwd);
		
		System.out.println(role+"---------"+name+"..."+addr+"..."+mob+"..."+email+"---------");
		out=response.getWriter();
		
		int flag;
		
			
			//adding cust's (role,username,pwd) in customer table
			flag=cs.addCustomer(c);
			System.out.println("flag="+flag);
			
			if(flag>0) {
				rd=request.getRequestDispatcher("SignUp.jsp");
				out.println("Successfully registered...Now, You can login");
				rd.include(request,response);
				
			}
			else {
				rd=request.getRequestDispatcher("SignUp.jsp");
				out.println("User with this username is already exist...");
				rd.include(request,response);
				
			}
			
			//adding cust's (role,username,pwd) in user table
			flag=us.addUser(u);

			if(flag>0) {
				out.println("customer added successfully");
			}
			else {
				out.println("failed to add customer");
			}
		}
	}

