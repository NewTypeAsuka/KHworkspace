package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository // DB 관련 + bean 등록(IOC)
public class CommentDAO {

	@Autowired // DI, root-context.xml에서 bean 등록
	private SqlSessionTemplate sqlSession;

	public List<Comment> select(int boardNo) {
		return sqlSession.selectList("boardMapper.selectCommentList", boardNo); // board-mapper.xml에 작성된 select 이용
	}

	// 댓글 삽입
	public int insert(Comment comment) {
		return sqlSession.insert("commentMapper.insert", comment);
	}

	// 댓글 삭제
	public int delete(int commentNo) {
		return sqlSession.update("commentMapper.delete", commentNo);
	}

	// 댓글 수정
	public int update(Comment comment) {
		return sqlSession.update("commentMapper.update", comment);
	}
	
}
