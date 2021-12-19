package model.service;

import java.util.List;
import java.util.Map;

import model.DAOFactory;
import model.dao.EcoerDAO;
import model.dao.PostDAO;
import model.dao.ReplyDAO;
import model.service.dto.PostDTO;
import model.service.dto.ReactDTO;
import model.service.dto.ReplyDTO;

public class PostManager {
	private static PostManager manager = new PostManager();
	private DAOFactory factory;
	private PostDAO postDAO;
	private ReplyDAO replyDAO;
	private EcoerDAO ecoerDAO;
	
	private PostManager() {
		try {
			factory = new DAOFactory();
			postDAO = factory.getPostDAO();
			replyDAO = factory.getReplyDAO();
			ecoerDAO = factory.getEcoerDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PostManager getInstance() {
		return manager;
	}
	
	public int insert(PostDTO post) {
		return postDAO.insertPost(post);
	}
	
	public int update(PostDTO post) {
		return postDAO.updatePost(post);
	}
	
	public int delete(int postId) {
		int result = -1;
		while(result == -1) {
			List<ReplyDTO> replies = replyDAO.getReplyListByPost(postId);
			for(ReplyDTO reply : replies) {
				result = replyDAO.deleteReply(reply.getReplyId());
				if(result == -1) break;
			}
			if(result != -1) result = postDAO.deleteReactByPid(postId);
			if(result != -1) result = postDAO.deletePost(postId);
		}
		return result;
	}
	
	public int view(int postId) {
		return postDAO.viewPost(postId);
	}
	
	public int like(int postId, String ecoerId) {
		ReactDTO reactDTO = ecoerDAO.getReactByEcoer(ecoerId);
		if(reactDTO.inLike(postId))
			return 0;
		return postDAO.likePost(ecoerId, postId);
	}
	
	public int report(int postId, String ecoerId) {
		ReactDTO reactDTO = factory.getEcoerDAO().getReactByEcoer(ecoerId);
		if(reactDTO.inReport(postId)) return -1;
		int count = postDAO.reportPost(ecoerId, postId);
		if(count >= 10) {
			delete(postId);
		}
		return count;
	}
	
	public List<PostDTO> getPostListByTitle(String title) {
		return postDAO.getPostListByTitle(title);
	}
	
	public PostDTO getPostByTitle(String title) {
		return postDAO.getPostByTitle(title);
	}
	
	public PostDTO getPostById(int id) {
		return postDAO.getPostByCode(id);
	}
	
	public List<PostDTO> display(int id) {
		return postDAO.getPostByCId(id);
	}
	
	public List<PostDTO> combineReplyCnt(List<PostDTO> origin, Map<Integer, Integer> cnt) {
		int index = 0;
		for(PostDTO post:origin) {
			post.setReplyCnt(cnt.getOrDefault(post.getPostId(), 0));
			origin.set(index, post);
			index++;
		}
		return origin;
	}
	
	public PostDAO getPostDAO() {
		return this.postDAO;
	}

	public List<PostDTO> findPostList(String keyword, String type) {
		return postDAO.getPostListByKeyword(keyword, type);
	}
}
