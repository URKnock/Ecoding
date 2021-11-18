package controller.project;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;
import model.Project;
import model.service.dto.*;

public class ViewProjectController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		int projectId = (int) request.getAttribute("projectId");
		
		// project_id를 이용하여 project를 찾아서 project에 대입한 후 request에 저장
		ProjectManager manager = ProjectManager.getInstance();
		Project project = manager.findProject(projectId);
		ProjectDTO projectDTO = manager.findProjectInfo(project);
		List<ProjectNoticeDTO> noticeList = manager.getNoticeList(projectId);

    	request.setAttribute("project", project);
    	request.setAttribute("projectDTO", projectDTO);
    	request.setAttribute("noticeList", noticeList);
		
		return "/project/projectSupport.jsp";
	}
}
