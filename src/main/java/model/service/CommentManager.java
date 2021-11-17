package model.service;

import java.util.List;

import model.service.dto.CommentDTO;

public interface CommentManager {
	public List<CommentDTO> ListingComments();	
	public CommentDTO findComment(int commentId);	
	public int insertComment(CommentDTO comment);
	public int updateComment(CommentDTO comment);	
	public int deleteComment(int commentNo);	
}
