package edu.kh.project.board.model.exception;

public class ImageDeleteException extends RuntimeException {

	public ImageDeleteException() {
		super("이미지 삭제에 실패했습니다.");
	}
}
