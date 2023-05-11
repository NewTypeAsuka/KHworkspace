package edu.kh.project.board.model.exception;

// 사용자 정의 예외를 만드는 방법
// -> Exception 관련 클래스를 상속받으면 됨

// tip) uncheckedException을 만들고 싶다면 RuntimeException을 상속받아서 구현
public class FileUploadException extends RuntimeException {

	public FileUploadException() {
		super("파일 업로드 중 예외 발생");
	}
	
	public FileUploadException(String message) {
		super(message);
	}
}
