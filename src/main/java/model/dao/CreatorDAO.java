package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Creator;
import model.service.dto.CreatorDTO;

public interface CreatorDAO {
	public List<CreatorDTO> getCreatorList();		
	public int insert(CreatorDTO creator);
	public int update(CreatorDTO creator);	
	public int confirm(CreatorDTO creator);
	public int delete(String ecoerId);
	public CreatorDTO findCreator(String ecoerId);
	public Creator findCreatorName(String creatorId) throws SQLException;
	public boolean existingCreator(String creatorId);
}
