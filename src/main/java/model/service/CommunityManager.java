package model.service;

import model.DAOFactory;
import model.dao.CommunityDAO;
import model.service.dto.CommunityDTO;

public class CommunityManager {
	private static CommunityManager manager = new CommunityManager();
	private DAOFactory factory;
	private CommunityDAO commDAO;
	
	private CommunityManager() {
		try {
			factory = new DAOFactory();
			commDAO = factory.getCommunityDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CommunityManager getInstance() {
		return manager;
	}
	
	public int insert(CommunityDTO comm) throws Exception {
		if(commDAO.getCommunity(comm.getCommunityId()) != null) {
			throw new Exception(comm.getCommunityId() + "번 커뮤니티는 이미 존재합니다.");
		}
		return commDAO.insertCommunity(comm);
	}
	
	public int update(CommunityDTO comm) {
		return commDAO.updateCommunity(comm);
	}
	
	public int delete(int commentId) {
		return commDAO.deleteCommunity(commentId);
	}
	
	public CommunityDTO getCommunity(int commentId) {
		return commDAO.getCommunity(commentId);
	}
	
	public CommunityDAO getCommunityDAO() {
		return this.commDAO;
	}
}
