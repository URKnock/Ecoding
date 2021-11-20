package model.dao.impl;

import java.util.List;
import model.DAOFactory;
import model.dao.ReplyDAO;
import model.service.dto.ReplyDTO;

public class ReplyManagerImpl {
	private ReplyDAO dao = null;
	public ReplyManagerImpl() {		
		DAOFactory factory = new DAOFactory();
		dao = factory.getReplyDAO();
	}
	public List<ReplyDTO> ListingReplys() {	
		return dao.getReplyList();
	}
	public int insert(ReplyDTO reply) {
		return dao.insertReply(reply);
	}
	public int update(ReplyDTO reply) {
		return dao.updateReply(reply);
	}
	public int delete(int replyId) {	
		return dao.deleteReply(replyId);
	}
	public ReplyDTO find(int replyId) {
		return dao.getReply(replyId);
	}
}
