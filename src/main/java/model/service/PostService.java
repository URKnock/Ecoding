package model.service;

import java.util.List;

import model.service.dto.PostDTO;

public interface PostService {	
	public List<PostDTO> ListingPosts();	
	public PostDTO getPost(String name);	
	public int insertPost(PostDTO post);
	public int updatePost(PostDTO post);	
	public int deletePost(int postNo);		
}
