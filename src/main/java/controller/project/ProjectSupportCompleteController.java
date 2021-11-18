package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;
import model.Support;
import model.service.dto.ProjectDTO;

public class ProjectSupportCompleteController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		Support support = (Support) request.getAttribute("support");
		
		ProjectManager manager = ProjectManager.getInstance();
		
		manager.supportProject(support);
		
		// 프로젝트 아이디로 제목을 찾은 후 저장 -> 출력할 타이틀
		ProjectDTO project = manager.findProjectSimpleInfo(support.getProjectId()); // or projectId
		request.setAttribute("project", project);
		
		return "/project/projectSupportComplete.jsp";
	}
}
