package model.dao;

import java.util.List;
import java.util.Map;

import model.service.dto.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> getReplyList();
	public List<ReplyDTO> getReplyListByPost(int postId);
	public int insertReply(ReplyDTO reply);
	public int updateReply(ReplyDTO reply);	
	public int deleteReply(int replyId);
	public ReplyDTO getReply(int replyId);
	public Map<Integer, Integer> getAllReplyCount();
}
