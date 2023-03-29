package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;

public class BoardService {

	private BoardDAO dao = new BoardDAO();
	private CommentDAO commentDao = new CommentDAO(); 

	/**
	 * 게시글 목록 조회 서비스
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception {
		
		Connection conn = getConnection();
		List<Board> boardList = dao.selectAllBoard(conn);
		close(conn);
		return boardList;
	}

	/**
	 * 게시글 상세 조회 서비스
	 * @param input
	 * @param memberNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int input, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		Board board = dao.selectBoard(conn, input);
		
		if(board != null) {
			List<Comment> commentList = commentDao.selectCommentList(conn, input);
			board.setCommentList(commentList);
			
			// 조회수 증가(게시글 작성자와 로그인 회원이 다를 경우)
			if(board.getMemberNo() != memberNo) {
				int result = dao.updateReadCount(conn, input); // 조회수 증가 DAO 메서드 호출
				if(result > 0) { // 트랜잭션 제어 처리 + 데이터 동기화 처리
					commit(conn);
					// 조회된 board의 조회수 (DB의 조회수는 1) -> 조회 결과인 board의 조회수도 1 증가
					board.setReadCount(board.getReadCount() + 1);
				} else rollback(conn);
			}
		}
		close(conn);
		return board;
	}

	/**
	 * 게시글 수정 서비스
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, String boardContent, int boardNo) throws Exception {

		Connection conn = getConnection();
		int result = dao.updateBoard(conn, boardTitle, boardContent, boardNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	/**
	 * 게시글 삭제 서비스
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn, boardNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	/**
	 * 게시글 등록 서비스
	 * @param boardTitle
	 * @param string
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(String boardTitle, String boardContent, int memberNo) throws Exception {

		Connection conn = getConnection();
		// 다음 게시글 번호 생성
		int boardNo = dao.nextBoardNo(conn);
		// 제목, 내용, 회원 번호, 다음 게시글 번호 전달
		int result = dao.insertBoard(conn, boardTitle, boardContent, memberNo, boardNo);
		if(result > 0) {
			commit(conn);
			result = boardNo; // 삽입 성공 시 다음 게시글 번호 전달
		}
		else rollback(conn);
		close(conn);
		return result;
	}
}
