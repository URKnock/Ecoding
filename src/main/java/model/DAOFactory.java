package model;

import model.dao.*;
import model.dao.impl.*;

public class DAOFactory {
	
	public PostDAO getPostDAO() {
		return new PostDAOImpl();		 
	}
	
	public ReplyDAO getReplyDAO() {
		return new ReplyDAOImpl();		
	}
	
	public CommunityDAO getCommunityDAO() {
		return new CommunityDAOImpl();		
	}
	
	//211113 ProejectDAO, SupportDAO 추가 (진주)
	public ProjectDAO getProjectDAO() {
		return new ProjectDAOImpl();		
	}
	
	public SupportDAO getSupportDAO() {
		return new SupportDAOImpl();		
	}
	
	public ProjectNoticeDAO getNoticeDAO() {
		return new ProjectNoticeDAOImpl();
	}
	
	public RewardDAO getRewardDAO() {
		return new RewardDAOImpl();
	}
	
	//EcoerDAO, CreatorDAO, InterestProjectDAO
	public EcoerDAO getEcoerDAO() {
		return new EcoerDAOImpl();
	}
	
	public CreatorDAO getCreatorDAO() {
		return new CreatorDAOImpl();
	}
	
	public InterestProjectDAO getInterestProjectDAO() {
		return new InterestProjectDAOImpl();
	}
	
}
