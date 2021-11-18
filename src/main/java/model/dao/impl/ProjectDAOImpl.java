package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.dao.ProjectDAO;
import model.util.JDBCUtil;
import model.service.dto.ProjectDTO;

public class ProjectDAOImpl implements ProjectDAO {
	private JDBCUtil jdbcUtil = null;
	public ProjectDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}	

	public int create(Project project) {
		String insertQuery = "INSERT INTO PROJECT(project_id, title) VALUES (seq_project.nextval, ?)";
		
		Object[] param = new Object[] {project.getTitle()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	@Override
	public int update(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Project findProject(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectList(int currentPage, int countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectInCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfProjectInCategory(String categoryName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existingProject(String projectId) {
		// TODO Auto-generated method stub
		return false;
	}
}
