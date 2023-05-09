package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	List<Map<String, Object>> selectBoardTypeList();

	/**
	 * 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardTypeList(int boardCode, int cp);

	/**
	 * 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);

	/**
	 * 좋아요 체크
	 * @param map
	 * @return result
	 */
	int boardLikeCheck(Map<String, Object> map);

}
