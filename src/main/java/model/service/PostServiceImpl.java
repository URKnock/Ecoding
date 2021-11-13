package model.service;

import java.util.List;
import model.DAOFactory;
import model.dao.PostDAO;
import model.service.dto.PostDTO;

public class PostServiceImpl implements PostService {
	private PostDAO dao = null;
	public PostServiceImpl() {		
		DAOFactory factory = new DAOFactory();
		dao = factory.getPostDAO();
	}
	public List<PostDTO> ListingPosts() {	
		return dao.getPostList();
	}
	public PostDTO getPost(String title) {		
		return dao.getPostByTitle(title);
	}
	public int insertPost(PostDTO post) {
		return dao.insertPost(post);
	}
	public int updatePost(PostDTO post) {
		return dao.updatePost(post);
	}
	public int deletePost(int postNo) {	
		return dao.deletePost(postNo);
	}
}
