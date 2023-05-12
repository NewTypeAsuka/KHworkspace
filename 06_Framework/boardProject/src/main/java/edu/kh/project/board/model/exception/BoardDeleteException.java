package edu.kh.project.board.model.exception;

public class BoardDeleteException extends RuntimeException {

	public BoardDeleteException() {
		super("게시판 삭제에 실패했습니다.");
	}
}
