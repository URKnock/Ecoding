package model.dao;

import java.util.List;

import model.service.dto.EcoerDTO;

public interface EcoerDAO {
	public List<EcoerDTO> getEcoerList();		
	public int insert(EcoerDTO ecoer);
	public int update(EcoerDTO ecoer);	
	public int delete(String ecoerId);
	public EcoerDTO findEcoer(String ecoerId);
}
