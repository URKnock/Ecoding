package model.service;

import java.util.List;

import model.DAOFactory;
import model.dao.PostDAO;
import model.service.dto.PostDTO;

public class PostManager {
	private static PostManager manager = new PostManager();
	private DAOFactory factory;
	private PostDAO postDAO;
	
	private PostManager() {
		try {
			factory = new DAOFactory();
			postDAO = factory.getPostDAO();
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
	
	public PostDTO getPostByTitle(String title) {
		return postDAO.getPostByTitle(title);
	}
	
	public PostDTO getPostById(int id) {
		return postDAO.getPostByCode(id);
	}
	
	public List<PostDTO> display() {
		return postDAO.getPostList();
	}
	
	public PostDAO getPostDAO() {
		return this.postDAO;
	}

	public List<PostDTO> findPostList(String keyword, String type) {
		// DB 검색 기능 구현할 것 = LIKE 연산자
		return null;
	}
}
