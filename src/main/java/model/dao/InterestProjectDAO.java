package model.dao;

import java.util.List;

import model.service.dto.InterestProjectDTO;

public interface InterestProjectDAO {
	public List<InterestProjectDTO> getInterestProjectList();		
	public int insert(InterestProjectDTO interest_project);
	public int update(InterestProjectDTO interest_project);	
	public int delete(String ecoerId);
	public InterestProjectDTO findInterestProject(String ecoerId);
	public boolean existingInterestProject(String interest_projectId);
}
