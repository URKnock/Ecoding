package model.service;

import java.util.List;

import model.DAOFactory;
import model.dao.EcoerDAO;
import model.dao.PostDAO;
import model.service.dto.PostDTO;
import model.service.dto.ReactDTO;

public class PostManager {
	private static PostManager manager = new PostManager();
	private DAOFactory factory;
	private PostDAO postDAO;
	private EcoerDAO ecoerDAO;
	
	private PostManager() {
		try {
			factory = new DAOFactory();
			postDAO = factory.getPostDAO();
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
		return postDAO.deletePost(postId);
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
		if(reactDTO.inReport(postId))
			return 0;
		return postDAO.reportPost(ecoerId, postId);
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
	
	public PostDAO getPostDAO() {
		return this.postDAO;
	}

	public List<PostDTO> findPostList(String keyword, String type) {
		return postDAO.getPostListByKeyword(keyword, type);
	}
}
