package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
//import model.User;
//import model.service.UserManager;
//import model.service.UserNotFoundException;

import model.service.*;
import model.Project;

public class ViewProjectController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		int project_id = (int) request.getAttribute("project_id");
		Project project = null;
		
		// project_id를 이용하여 project를 찾아서 project에 대입한후 request에 저장
		ProjectManager manager = ProjectManager.getInstance();
		project = manager.findProject(project_id);

    	request.setAttribute("project", project);
		
		return "/projectSupport.jsp";
	}
}
