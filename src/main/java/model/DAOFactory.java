package model;

import model.dao.*;
import model.dao.impl.*;

public class DAOFactory {
	
	public PostDAO getPostDAO() {
		return new PostDAOImpl();		 
	}
	
	public CommentDAO getCommentDAO() {
		return new CommentDAOImpl();		
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
}
