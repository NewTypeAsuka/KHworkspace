package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

@SessionAttributes({"loginMember"})
// 1) Model에 세팅된 값의 key와 {} 작성된 값이 일치하면 sessionScope로 이동
// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게 함
//		-> @SessionAttribute(key)로 사용
@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받음
@Controller // 요청/응답 제어 클래스 + Bean 등록 (IOC)
public class MyPageController {
	
	@Autowired // MyPageService의 자식 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;
	
	// 내 정보 페이지 이동
	@GetMapping("/info")
	public String info() {
		// ViewResolver 설정 -> servlet-context.xml 참고
		return "myPage/myPage-info";
	}
	
	// 프로필 페이지 이동
	@GetMapping("/profile")
	public String profile() {
		return "myPage/myPage-profile";
	}
	
	// 비밀번호 변경 페이지 이동
	@GetMapping("/changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	// 탈퇴 페이지 이동
	@GetMapping("/secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	// 회원 정보 수정
	@PostMapping("/info")
	public String updateInfo(Member updateMember, String[] memberAddress,
					@SessionAttribute("loginMember") Member loginMember,
					RedirectAttributes ra) {
		
		// 주소 하나로 합치기 (a^^^b^^^c)
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		// 로그인한 회원의 번호를 updateMember에 추가
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// 회원 정보 수정(UPDATE) 서비스 호출
		int result = service.updateInfo(updateMember);
		
		String message = null;
		
		if(result > 0) { // 성공
			message = "회원 정보가 수정되었습니다.";
			
			// Session에 로그인된 회원 정보도 수정(동기화)
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
		} else { // 실패
			message = "회원 정보 수정에 실패하였습니다.";
		}
		
		return "redirect:info";
	}
}
