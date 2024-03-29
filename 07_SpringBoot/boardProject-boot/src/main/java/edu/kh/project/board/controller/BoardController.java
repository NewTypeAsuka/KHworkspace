package edu.kh.project.board.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/*
	 * 목록 조회: /board/1?cp=1 (cp: current page)
	 * 상세 조회: /board/1/1500?cp=1
	 * 
	 * ** 컨트롤러 따로 생성 예정 **
	 * 삽입: /board2/insert?code=1 (code == BOARD_CODE, 게시판 종류)
	 * 수정: /board2/update?code=1&no=1500 (no == BOARD_NO, 게시글 번호)
	 * 삭제: /board2/delete?code=1&no=1500
	 */
	
	// @PathVariable: url 경로에 있는 값을 매개 변수로 이용할 수 있게 하는 어노테이션
	// + requestScope에 세팅
	
	// @PathVariable을 사용하는 경우
	// - 자원(resource) 구분/식별
	// ex) github.com/sangzoon0102
	// ex) /board/1 -> 1번(공지사항) 게시판
	// ex) /board/2 -> 2번(자유 게시판) 게시판
	
	// QueryString을 사용하는 경우
	// - 정렬, 필터링 등 식별을 제외한 거의 모든 경우
	// ex) search.naver.com?query=날씨
	// ex) search.naver.com?query=점심
	// ex) search.naver.com?code=1
	// ex) search.naver.com?code=2
	// -> 삽입이라는 공통된 동작 수행(code에 따라 어디에 삽입할지 지정)
	
	// ex) /board/list?order=recent (최신순)
	// ex) /board/list?order=most (인기순)
	
	// ***** @PathVariable 사용 시 문제점과 해결방법 *****
	// 문제점: 요청 주소와 @PathVariable로 가져다 쓸 주소의 레벨이 같다면 구분하지 않고 모두 매핑되는 문제 발생
	// 			-> 요청을 했는데 원하는 메서드 실행 X
	// 해결방법: @PathVariable 지정 시 정규 표현식 사용
	//			{키:정규표현식}
	
	
	// 게시글 목록 조회
	@GetMapping("/{boardCode:[0-9]+}") // boardCode는 1자리 이상 숫자
	public String selectBoardList(
			@PathVariable("boardCode") int boardCode,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model,
			@RequestParam Map<String, Object> paramMap // 파라미터 전부 다 담겨있음
			) {
		
		// boardCode 확인
//		System.out.println("boardCode: " + boardCode);
		
		if(paramMap.get("key") == null) { // 검색어가 없을 때(검색 X)
			// 게시글 목록 조회 서비스 호출
			Map<String, Object> map = service.selectBoardList(boardCode, cp);
			
			// 조회 결과를 requestScope에 세팅 후 forward
			model.addAttribute("map", map);
		} else { // 검색어가 있을 때(검색 O)
			
			paramMap.put("boardCode", boardCode);
			
			Map<String, Object> map = service.selectBoardList(paramMap, cp); // 오버로딩
			
			model.addAttribute("map", map);
		}
		
		return "board/boardList";
	}
	
	// @PathVariable: 주소에 지정된 부분을 변수에 저장 + requestScope 세팅
	
	// 게시글 상세 조회
	@GetMapping("/{boardCode}/{boardNo}")
	public String boardDetail(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model, // 데이터 전달용 객체
			RedirectAttributes ra, // 리다이렉트 시 데이터 전달용 객체
			@SessionAttribute(value="loginMember", required=false) Member loginMember,
			// 세션에서 loginMember를 얻어오는데 없으면 null, 있으면 회원정보 저장
			
			// 쿠키를 이용한 조회수 증가에 사용
			HttpServletRequest req, 
			HttpServletResponse resp
			) throws ParseException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		// 게시글 상세 조회 서비스 호출
		Board board = service.selectBoard(map);
		
		String path = null;
		
		if(board != null) { // 조회 결과가 있을 경우
			
			//----------------------------------------------------------------------------
			// 현재 로그인 상태인 경우 로그인한 회원이 해당 게시글에 좋아요를 눌렀는지 확인

			if(loginMember != null) { // 로그인 상태인 경우
				map.put("memberNo", loginMember.getMemberNo()); // 회원 번호를 map에 추가
				int result = service.boardLikeCheck(map); // 좋아요 여부 확인 서비스 호출
				if(result > 0) model.addAttribute("likeCheck", "on"); // 누른 적이 있을 경우
			}
			
			//----------------------------------------------------------------------------
			// 쿠키를 이용한 조회수 증가 처리
			
			// 1) 비회원 또는 로그인한 회원의 글이 아닌 경우
			if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {
				
				// 2) 쿠키 얻어오기
				Cookie c = null;
				Cookie[] cookies = req.getCookies(); // 요청에 담긴 모든 쿠키 얻어오기
				
				if(cookies != null) { // 쿠키가 존재할 경우
					
					// 쿠키 중 "readBoardNo"라는 쿠키를 찾아서 c에 대입
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("readBoardNo")) {
							c = cookie;
							break;
						}
					}
				}
				
				// 3) 기존 쿠키가 없거나(c == null)
				//		존재는 하나 현제 게시글 번호가 쿠키에 저장되지 않은 경우(오늘 해당 게시글 본 적 없음)
				int result = 0;
				
				if(c == null) {
					// 쿠키가 존재 X -> 하나 새로 생성
					c = new Cookie("readBoardNo", "|"+boardNo+"|");
					
					result = service.updateReadCount(boardNo); // 조회수 증가 서비스 호출
				} else {
					
					// 현재 게시글 번호가 쿠키에 있는지 확인
					// Cookie.getValue(): 쿠키에 저장된 모든 값을 읽어옴 -> String으로 반환
					// String.indexOf("문자열"): 찾는 문자열이 String이 몇번 인덱스에 존재하는지 반환(없으면 -1 반환)
					if(c.getValue().indexOf("|"+boardNo+"|") == -1) {
						// 쿠키에 현재 게시글 번호가 없다면 
						c.setValue(c.getValue() + "|"+boardNo+"|"); // 기존 값에 게시글 번호 추가해서 다시 세팅
					
						result = service.updateReadCount(boardNo); // 조회수 증가 서비스 호출
					}
				} // 3) 종료
				
				// 4) 조회수 증가 성공시 쿠키가 적용되는 경로, 수명(당이 23시 59분 59초까지)
				if(result > 0) {
					board.setReadCount(board.getReadCount() + 1); // 조회된 board 조회 수와 DB의 조회수 동기화
					
					c.setPath("/"); // 적용 경로 설정 -> "/" 이하 경로 요청 시 쿠키 서버로 전달
					
					Calendar cal = Calendar.getInstance(); // 수명 지정 -> 싱글톤 패턴
					cal.add(cal.DATE, 1);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 표기법 변경 객체(DB의 TO_CHAR와 비슷)
					
					Date a = new Date(); // 현재 시간(java.util.Date)
					
					Date temp = new Date(cal.getTimeInMillis()); // 내일(24시간 후)
					
					Date b = sdf.parse(sdf.format(temp)); // 내일 0시 0분 0초
					
					// 내일 0시 0분 0초 - 현재 시간 -> 내일 0시 0분 0초까지 남은 시간 초 단위 반환
					long diff = (b.getTime() - a.getTime()) / 1000;
					
					c.setMaxAge((int)diff); // 수명 설정
					
					resp.addCookie(c); // 응답 객체를 이용해서 클라이언트에게 전달
				}
			}
			
			//----------------------------------------------------------------------------
			
			path = "board/boardDetail"; // forward할 jsp 경로
			model.addAttribute("board", board);
			
			// 게시글에 이미지가 있을 경우
			if(!board.getImageList().isEmpty()) {
				
				BoardImage thumbnail = null;
				
				// 0번 인덱스 이미지의 순서가 0인 경우 == 썸네일
				if(board.getImageList().get(0).getImageOrder() == 0) {
					thumbnail = board.getImageList().get(0);
				}
				model.addAttribute("thumbnail", thumbnail);
				model.addAttribute("start", thumbnail != null ? 1 : 0); // 썸네일 있으면 start=1 /  없으면 start=0
			}
			
		} else { // 조회 결과가 없을 경우
			path = "redirect:/board/" + boardCode; // 게시판 첫 페이지로 리다이렉트
			ra.addFlashAttribute("message", "해당 게시글이 존재하지 않습니다.");
		}
		
		return path;
	}
	
	// 좋아요 처리
	@PostMapping("/like")
	@ResponseBody // 반환되는 값이 비동기 요청한 곳으로 돌아가게 함
	public int like(@RequestBody Map<String, Integer> paramMap) {
		System.out.println(paramMap);
		return service.like(paramMap);
	}
	
    // 헤더 검색
    @GetMapping(value="/headerSearch", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Map<String, Object>> headerSearch(String query){
    	return service.headerSearch(query);
    }

	
	
}
