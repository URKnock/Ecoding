package model;

import model.dao.*;
import model.dao.impl.*;

public class DAOFactory {
	
	//public PostDAO getPostDAO() {
	//	return new PostDAOImpl();		 
	//}
	
	//public CommentDAO getCommentDAO() {
	//	return new CommentDAOImpl();		
	//}
	
	//public CommunityDAO getCommunityDAO() {
	//	return new CommunityDAOImpl();		
	//}
	
	public SupportDAO getPostDAO() {
		return new SupportDAOImpl();		 
	}
	
	public ProjectDAO getProejectDAO() {
		return new ProjectDAOImpl();
	}
}
