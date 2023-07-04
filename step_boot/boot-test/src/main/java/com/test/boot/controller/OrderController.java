package com.test.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

	@PostMapping("orderProduct.do")
	public String order(
			String name,
			int blackPen,
			int redPen,
			int bluePen,
			int white, 
			Model model) {
		
		int blackPrice = 500 * blackPen;
		int redPrice = 700 * redPen;
		int bluePrice = 700 * bluePen;
		int whitePrice = 1000 * white;
		int totalPrice = blackPrice + redPrice + bluePrice + whitePrice;
		String buyer = name;
		
		model.addAttribute("blackPen", blackPen);
		model.addAttribute("redPen", redPen);
		model.addAttribute("bluePen", bluePen);
		model.addAttribute("white", white);
		
		model.addAttribute("blackPrice", blackPrice);
		model.addAttribute("redPrice", redPrice);
		model.addAttribute("bluePrice", bluePrice);
		model.addAttribute("whitePrice", whitePrice);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("buyer", buyer);
		
		String path = "";
		
		if(totalPrice == 0) {
			path="errorPage";
		} else {
			path="resultPage";
		}
		
		return path;
	}
}
