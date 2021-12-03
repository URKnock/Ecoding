package model.dao;

import java.util.List;

import model.service.dto.InterestProjectDTO;
import model.Project;

public interface InterestProjectDAO {
	public List<InterestProjectDTO> getInterestProjectList();		
	public int insert(InterestProjectDTO interest_project);
	public int update(InterestProjectDTO interest_project);	
	public int delete(InterestProjectDTO interestDTO);
	public InterestProjectDTO findInterestProject(String ecoerId);
	public List<Project> getInterestProjectList(String ecoerId);
	public boolean existingInterestProject(String interest_projectId);
	public boolean isInterestProject(InterestProjectDTO interestDTO);
}
