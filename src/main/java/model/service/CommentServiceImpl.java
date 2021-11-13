package model.service;

import java.util.List;
import model.DAOFactory;
import model.dao.CommentDAO;
import model.service.dto.CommentDTO;

public class CommentServiceImpl implements CommentService {
	private CommentDAO dao = null;
	public CommentServiceImpl() {		
		DAOFactory factory = new DAOFactory();
		dao = factory.getCommentDAO();
	}
	public List<CommentDTO> ListingComments() {	
		return dao.getCommentList();
	}
	public int insertComment(CommentDTO comment) {
		return dao.insertComment(comment);
	}
	public int updateComment(CommentDTO comment) {
		return dao.updateComment(comment);
	}
	public int deleteComment(int commentNo) {	
		return dao.deleteComment(commentNo);
	}
	public CommentDTO findComment(int commentId) {
		return dao.findComment(commentId);
	}
}
