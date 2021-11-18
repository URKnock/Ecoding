package model.dao;

import java.util.List;

import model.service.dto.PostDTO;

public interface PostDAO {
	public List<PostDTO> getPostList();	
	public List<PostDTO> getPostListByTitle(String pTitle);
	public List<PostDTO> getPostByCId(int id);
	public int insertPost(PostDTO post);
	public int updatePost(PostDTO post);	
	public int deletePost(int pId);		
	public PostDTO getPostByCode(int pCode);
	public PostDTO getPostByTitle(String title);
}
