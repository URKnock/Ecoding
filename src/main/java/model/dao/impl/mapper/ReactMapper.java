package model.dao.impl.mapper;

import org.apache.ibatis.annotations.Param;

public interface ReactMapper {

	public int viewPost(int id);
	public int likePost(int id);
	public int reportPost(int id);
	public int getReportCount(int id);
	public int insertLikeEcoer(@Param("ecoerId") String ecoerId,
							  @Param("postId") int postId);
	public int insertReportEcoer(@Param("ecoerId") String ecoerId,
			  				  	@Param("postId") int postId);
}
