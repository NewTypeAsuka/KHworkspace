package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleController1 extends HttpServlet{

	// doGet() 메서드
	// -> GET 방식 요청을 처리하는 메서드
	// -> HttpServlet 메서드 오버라이딩
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest
		// - 클라이언트 요청 시 생성되는 객체
		// - 클라이언트 데이터 + 요청 관련 데이터
		
		// HttpServletRequestResponse
		// - 클라이언트 요청 시 서버에서 생성하는 객체
		// - 서버가 클라이언트에게 응답하기 위한 방법을 제공하는 객체
		
		System.out.println("--- 이름, 나이를 입력받아 처리하는 코드 ---");
		
		// 요청 시 입력된 이름, 나이를 전달받아 오기
		// String req.getParameter("name속성값");
		// -> 요청 시 전달된 데이터 중 name 속성값이 일치하는 데이터의 value를 얻어와 String 형태로 반환
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge"); // HTML에서 얻어오는 모든 값은 String
		System.out.println("입력받은 이름: " + name);
		System.out.println("입력받은 나이: " + age);
		
		// 서버 -> 클라이언트 응답하기
		// HttpServletResponse 객체 이용
		// 응답하는 문서의 형식과 인코딩을 지정
		// - text/html: 글자가 작성된 HTML 문서 (mime type)
		// - charset=UTF-8: UTF-8 형식의 문자 인코딩으로 작성
		resp.setContentType("text/html; charset=UTF-8");
		
		// 서버 -> 클라이언트로 연결되는 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		// Writer: 서버 -> 클라이언트에게 쓰다(출력)
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
			out.println("<title>서버 응답 결과</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>");
			out.println(name + "님의 나이는 " + age + "세 입니다.");
			out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}