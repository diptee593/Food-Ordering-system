package com.yummyfork.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummyfork.dto.Food;
import com.yummyfork.services.FoodService;

@WebServlet("/AddFoodController")
public class AddFoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FoodService fs;

	public AddFoodController() {
		super();
		fs = new FoodService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		response.setContentType("text/html");
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();

		if (operation != null && operation.equalsIgnoreCase("edit")) {

			int id = Integer.parseInt(request.getParameter("foodId"));
			Food f = fs.getFoodById(id);
			request.setAttribute("food", f);
			rd = request.getRequestDispatcher("UpdateFood.jsp");
			rd.forward(request, response);

		} else if (operation != null && operation.equalsIgnoreCase("delete")) {
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			int deleteFlag = fs.deleteFood(foodId);
			if (deleteFlag > 0) {
				out.println("success deleting food");
				response.sendRedirect("AddFoodController");
			} else {
				out.println("error deleting food");
				rd = request.getRequestDispatcher("AddFoodController?operation=");
				rd.include(request, response);
			}

		} else {
			List<Food> foodList = fs.getAllFood();
			request.setAttribute("foodList", foodList);
			rd = request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		String operation = request.getParameter("operation");

		if (operation != null && operation.equalsIgnoreCase("addFood")) {

			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String category = request.getParameter("category");

			Food f = new Food(name, price, quantity, category);
			rd = request.getRequestDispatcher("Home.jsp");
			int flag = fs.addFood(f);

			if (flag > 0) {
				out.println("Success adding food");

				rd.include(request, response);
			} else {
				out.println("fail to add food");
				rd.include(request, response);
			}
		} else if (operation != null && operation.equalsIgnoreCase("update")) {

			System.out.println("entered into addcontroller update ..........");

			int id = Integer.parseInt(request.getParameter("foodId"));
			String name = request.getParameter("foodName");
			double price = Double.parseDouble(request.getParameter("foodPrice"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String category = request.getParameter("category");

			System.out.println(id + "------" + name + "------" + price + "------" + quantity + "------" + category);

			Food f = new Food(id, name, price, quantity, category);

			int flag = fs.updateFood(f);
			System.out.println("inside addFoodController flag= " + flag);
			if (flag > 0) {
				response.sendRedirect("AddFoodController?operation=");
			} else {
				response.sendRedirect("AddFoodController?operation=");
			}
		} else if (operation != null && operation.equals("searchFood")) {

			String foodName = request.getParameter("search");

			System.out.println("foodName===>" + foodName);

			List<Food> foodList = fs.getFoodByName(foodName);

			request.setAttribute("foodList", foodList);
			rd = request.getRequestDispatcher("ShowSearchFood.jsp");
			rd.forward(request, response);
			
		}

	}
}
