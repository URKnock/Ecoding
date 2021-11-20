package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Project;
import model.Reward;
import model.service.dto.ProjectDTO;

public interface ProjectDAO {
	public Project create(Project project);
	public int updateProjectForm(Project project);
	public int update(Project project);
	public int remove(String projectId) throws SQLException;
	public Project findProject(int projectId) throws SQLException;
	public List<Project> findProjectList() throws SQLException;
	public List<Project> findProjectList(int currentPage, int countPerPage) throws SQLException;
	public List<Project> findProjectInCategory(String categoryName) throws SQLException;
	public int getNumberOfProjectInCategory(String categoryName);
	public boolean existingProject(String projectId) throws SQLException;
}
