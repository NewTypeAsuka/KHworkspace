package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 상대경로의 경우 매핑할 주소 제일 앞에 /를 적지 않은 경우 <url-pattern> 에러 발생
@WebServlet("/scope")
public class ScopeController extends HttpServlet {
	
	// a태그, 주소창에 직접 작성, JS 요청은 GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp"); // webapp 폴더 기준으로 jsp 경로 작성
		
		// 1. pageScope -> JSP에서 확인
		
		// 2. requestScope -> 요청받은 페이지+위임받은 페이지
		req.setAttribute("message", "requestScope에 저장된 메시지입니다");
		
		// 3. sessionScope -> 브라우저당 1개, 브라우저가 종료 또는 session 만료까지 유지
		
		// session 객체 얻어오는 방법
		HttpSession session = req.getSession();
		// ** 모든 scope는 속성을 세팅하고 얻어오는 방법이 동일 **
		session.setAttribute("sessionValue", "999");
		
		// 4. applicationScope -> 서버가 켜져있는 동안 유지
		
		// application 객체를 얻어오는 방법
		ServletContext application = req.getServletContext();
//		ServletContext application = session.getServletContext();
		// request, session 객체에서 얻어오기 가능
		application.setAttribute("appValue", 10000);
		
		// 모든 범위에 같은 key(str)로 속성 세팅
		req.setAttribute("str", "request 범위의 세팅된 문자열");
		session.setAttribute("str", "session 범위의 세팅된 문자열");
		application.setAttribute("str", "application 범위의 세팅된 문자열");
		
		
		
		
		// 요청 위임
		dispatcher.forward(req, resp);
	}
}
