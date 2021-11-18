package model.dao;

import java.util.List;

import model.Project;
import model.service.dto.ProjectDTO;

public interface ProjectDAO {
	public int create(Project project);
	public int update(Project project);
	public int remove(String projectId);
	public Project findProject(int projectId);
	public List<Project> findProjectList();
	public List<Project> findProjectList(int currentPage, int countPerPage);
	public List<Project> findProjectInCategory(String categoryName);
	public int getNumberOfProjectInCategory(String categoryName);
	public boolean existingProject(String projectId);
}
