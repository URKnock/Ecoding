package model.service;

import java.util.List;
import java.util.Map;

import model.DAOFactory;
import model.dao.ReplyDAO;
import model.service.dto.ReplyDTO;

public class ReplyManager {
	private static ReplyManager manager = new ReplyManager();
	private DAOFactory factory;
	private ReplyDAO replyDAO;
	
	private ReplyManager() {
		try {
			factory = new DAOFactory();
			replyDAO = factory.getReplyDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReplyManager getInstance() {
		return manager;
	}
	
	public int insert(ReplyDTO reply) throws Exception {
		if(replyDAO.getReply(reply.getReplyId()) != null) {
			throw new Exception(reply.getReplyId() + "번 댓글은 이미 존재합니다.");
		}
		return replyDAO.insertReply(reply);
	}
	
	public int update(ReplyDTO reply) {
		return replyDAO.updateReply(reply);
	}
	
	public int delete(int replyentId) {
		return replyDAO.deleteReply(replyentId);
	}

	public List<ReplyDTO> display() {
		return replyDAO.getReplyList();
	}
	
	public List<ReplyDTO> getReplyListByPost(int postId) {
		return replyDAO.getReplyListByPost(postId);
	}	
	
	public ReplyDTO getReply(int replyentId) {
		return replyDAO.getReply(replyentId);
	}
	
	public Map<Integer, Integer> getAllReplyCount() {
		return replyDAO.getAllReplyCount();
	}
	
	public ReplyDAO getReplyDAO() {
		return this.replyDAO;
	}
	
	public int like() {
		return 0;
	}
	
	public int report() {
		return 0;
	}
}
