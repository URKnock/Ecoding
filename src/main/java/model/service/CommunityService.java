package model.service;

import model.service.dto.CommunityDTO;

public interface CommunityService {	
	public CommunityDTO getCommunity(int commId);	
	public int insertCommunity(CommunityDTO comm);
	public int updateCommunity(CommunityDTO comm);	
	public int deleteCommunity(int commNo);	
}
