package model.dao;

import java.util.List;

import model.service.dto.CommentDTO;

public interface CommentDAO {
	public List<CommentDTO> getCommentList();		
	public int insertComment(CommentDTO comment);
	public int updateComment(CommentDTO comment);	
	public int deleteComment(int commentNo);
	public CommentDTO findComment(int commentId);
}
