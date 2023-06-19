package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.CommentMapper;
import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.common.utility.Util;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper mapper;

	@Override
	public List<Comment> select(int boardNo) {
		return mapper.select(boardNo);
	}
	
	// 댓글 달기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insert(Comment comment) {
		// XSS 방지 처리
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		return mapper.insert(comment);
	}

	// 댓글 삭제
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int delete(int commentNo) {
		return mapper.delete(commentNo);
	}

	// 댓글 수정
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int update(Comment comment) {
		// XSS 방지 처리
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		return mapper.update(comment);
	}
	
	
	
}
