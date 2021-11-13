package model.service;

import model.Project;
import model.dao.ProjectDAO;


public class ProjectManager {
	private static ProjectManager projectMan = new ProjectManager();
	private ProjectDAO projectDAO; //Impl 통해서 가져오기
	
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

}
