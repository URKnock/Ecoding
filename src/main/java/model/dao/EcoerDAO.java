package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Ecoer;
import model.service.dto.EcoerDTO;
import model.service.dto.ReactDTO;

public interface EcoerDAO {
	public List<EcoerDTO> getEcoerList();		
	public int insert(EcoerDTO ecoer);
	public int update(EcoerDTO ecoer);	
	public int delete(String ecoerId);
	public EcoerDTO findEcoer(String ecoerId);
	public Ecoer findEcoerInfo(String ecoerId) throws SQLException;
	public ReactDTO getReactByEcoer(String ecoerId);
	public boolean existingEcoer(String ecoerId);
}