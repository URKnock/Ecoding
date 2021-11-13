package model.dao;

import java.util.List;

import model.service.dto.PostDTO;

public interface PostDAO {
	public List<PostDTO> getPostList();		
	public int insertPost(PostDTO post);
	public int updatePost(PostDTO post);	
	public int deletePost(int pId);		
	public PostDTO getPostByTitle(String pTitle);	
	public PostDTO getPostByCode(int pCode);
}
