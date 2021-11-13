package model.service;

import model.DAOFactory;
import model.dao.CommunityDAO;
import model.service.dto.CommunityDTO;

public class CommunityServiceImpl implements CommunityService {
	private CommunityDAO dao = null;
	public CommunityServiceImpl() {		
		DAOFactory factory = new DAOFactory();
		dao = factory.getCommunityDAO();
	}
	public int insertCommunity(CommunityDTO comm) {
		return dao.insertCommunity(comm);
	}
	public int updateCommunity(CommunityDTO comm) {
		return dao.updateCommunity(comm);
	}
	public int deleteCommunity(int commNo) {	
		return dao.deleteCommunity(commNo);
	}
	public CommunityDTO getCommunity(int commId) {
		return dao.getCommunity(commId);
	}
}
