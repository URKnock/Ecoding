package model.dao;

import model.service.dto.CommunityDTO;

public interface CommunityDAO {
	public int insertCommunity(CommunityDTO comm);
	public int updateCommunity(CommunityDTO comm);	
	public int deleteCommunity(int commNo);			
	public CommunityDTO getCommunity(int comCode);
}
