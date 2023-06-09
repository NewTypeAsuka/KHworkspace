package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainForward(Model model) {
		
		model.addAttribute("name", "홍길동");
		
		// Spring MVC의 경우 /webapp/WEB-INF/views/common/main.jsp로 forward
		// SpringBoot의 경우(+thymeleaf 템플릿 엔진 적용 == jsp 대신 사용)
		// src/main/resources/templates/common/main.html로 forward
		return "common/main";
	}
	
	@GetMapping("/loginError")
	public String loginError(RedirectAttributes ra) {
		
		ra.addFlashAttribute("message", "로그인 후 이용해주세요.");
		
		return "redirect:/";
	}
}
