package com.kh.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orderProduct.do")
public class OrderServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. name으로 인식된 변수를 재배정
        String name = req.getParameter("name");
        int blackPen = Integer.parseInt(req.getParameter("blackPen"));
        int redPen = Integer.parseInt(req.getParameter("redPen"));
        int bluePen = Integer.parseInt(req.getParameter("bluePen"));
        int white = Integer.parseInt(req.getParameter("white"));
        
        // 2. 각 값 계산
        int blackPrice = blackPen * 500;
        int redPrice = redPen * 700;
        int bluePrice = bluePen * 700;
        int whitePrice = white * 1000;
        int total = blackPrice + redPrice + bluePrice + whitePrice;
        
        if (total != 0) { // 3-1. 제대로 입력된 경우
            req.setAttribute("name", name); // 이름
            req.setAttribute("blackPen", blackPen); // 수량
            req.setAttribute("redPen", redPen); // 수량
            req.setAttribute("bluePen", bluePen); // 수량
            req.setAttribute("white", white); // 수량
            
            req.setAttribute("blackPrice", blackPrice); // 가격
            req.setAttribute("redPrice", redPrice); // 가격
            req.setAttribute("bluePrice", bluePrice); // 가격
            req.setAttribute("whitePrice", whitePrice); // 가격
            req.setAttribute("total", total); // 총합

            RequestDispatcher dispatcher =
            req.getRequestDispatcher("WEB-INF/views/resultPage.jsp");
            
            dispatcher.forward(req, resp);
            
        } else { // 3-2. 아무것도 입력되지 않은 경우
        	req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);
        }
		System.out.println("오더 페이지 출력");
	}
}
