package model.dao;

import java.util.List;

import model.service.dto.CreatorDTO;

public interface CreatorDAO {
	public List<CreatorDTO> getCreatorList();		
	public int insert(CreatorDTO creator);
	public int update(CreatorDTO creator);	
	public int delete(String ecoerId);
	public CreatorDTO findCreator(String ecoerId);
	public boolean existingCreator(String creatorId);
}
