package model.service;

import java.sql.SQLException;

import model.DAOFactory;
import model.dao.CreatorDAO;
import model.service.dto.CreatorDTO;
import model.service.dto.EcoerDTO;

public class CreatorManager {
	private static CreatorManager creatorMan = new CreatorManager();
	private DAOFactory factory;
	private CreatorDAO creatorDAO;
	
	private CreatorManager() {
		try {
			factory = new DAOFactory();
			creatorDAO = factory.getCreatorDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CreatorManager getInstance() {
		return creatorMan;
	}
	
	public int update(CreatorDTO creator) {
		return creatorDAO.confirm(creator);
	}	
}
