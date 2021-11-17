package model.service;

import java.sql.SQLException;
import java.util.List;

import model.DAOFactory;
import model.Project;
import model.Reward;
import model.dao.ProjectDAO;
import model.service.dto.PostDTO;


public class ProjectManager {
	private static ProjectManager projectMan = new ProjectManager();
	private DAOFactory factory;
	private ProjectDAO projectDAO; //Impl 통해서 가져오기
	
	private ProjectManager() {
		try {
			factory = new DAOFactory();
			projectDAO = factory.getProjectDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjectManager getInstance() {
		return projectMan;
	}

	public void supportProject() {
		// TODO Auto-generated method stub
		
	}

	public Project findProject(int project_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int registerProject(Project proj) throws SQLException {
		return projectDAO.create(proj);
	}

	public List<Reward> findRewardList(int project_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reward findReward(int reward_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateProject(Project proj) throws SQLException {
		return projectDAO.update(proj);
	}
	
	public int removeProject(String projId) throws SQLException {
		return projectDAO.remove(projId);
	};
}
