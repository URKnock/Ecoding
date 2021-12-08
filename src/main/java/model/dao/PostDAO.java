package model.dao;

import java.util.List;

import model.service.dto.PostDTO;

public interface PostDAO {
	public List<PostDTO> getPostList();	
	public List<PostDTO> getPostListByTitle(String pTitle);
	public List<PostDTO> getPostByCId(int id);
	public List<PostDTO> getPostListByKeyword(String keyword, String type);
	public int insertPost(PostDTO post);
	public int updatePost(PostDTO post);	
	public int deletePost(int pId);
	public int viewPost(int id);
	public int likePost(String ecoerId, int postId);
	public int reportPost(String ecoerId, int postId);
	public PostDTO getPostByCode(int pCode);
	public PostDTO getPostByTitle(String title);
}
