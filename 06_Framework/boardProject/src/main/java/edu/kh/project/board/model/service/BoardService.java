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
	 * 좋아요 여부 확인
	 * @param map
	 * @return result
	 */
	int boardLikeCheck(Map<String, Object> map);

	/**
	 * 좋아요 깜빡깜빡
	 * @param paramMap
	 * @return count
	 */
	int like(Map<String, Integer> paramMap);

	/**
	 * 조회수 증가
	 * @param boardNo
	 * @return result
	 */
	int updateReadCount(int boardNo);

	/**
	 * 게시글 목록 조회(검색)
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);
	
	/** 헤더 검색
	 * @param query
	 * @return list
	 */
	List<Map<String, Object>> headerSearch(String query);

}
