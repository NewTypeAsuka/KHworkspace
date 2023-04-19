package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Pizza;

@WebServlet("/pizzaOrder")
public class PizzaController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Pizza> pizzaList = new ArrayList<>();
		
		pizzaList.add(new Pizza("치즈 피자", 8000));
		pizzaList.add(new Pizza("콤비네이션 피자", 9000));
		pizzaList.add(new Pizza("핫치킨 피자", 10000));
		
		// 문자 인코딩 일치
		req.setCharacterEncoding("UTF-8");
		
		// parameter
		String pizza = req.getParameter("pizza"); // 1, 2, 3
		String size = req.getParameter("size"); // R, L
		String amount = req.getParameter("amount"); // 수량(0 이상)
		
		Pizza p = pizzaList.get(Integer.parseInt(pizza) - 1); // 피자 종류 파악
		String pizzaName = p.getName(); // 피자 이름
		int price = p.getPrice(); // 피자 가격
		if(size.equals("L")) price += 2000; // L 사이즈 2천원 추가
		price *= Integer.parseInt(amount);  // 전체 가격
		
		// req에 pizzaName, price를 속성으로 추가
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		// JSP로 요청 위임 -> Servlet에서 응답 화면 만들기 힘들어서
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp");
		
		// 요청 위임
		dispatcher.forward(req, resp);
	}
}
