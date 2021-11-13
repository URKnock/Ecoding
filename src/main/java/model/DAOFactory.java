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
}
