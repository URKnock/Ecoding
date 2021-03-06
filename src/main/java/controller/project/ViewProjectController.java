package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProjectManager;
import model.Project;
import model.service.dto.*;

public class ViewProjectController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		// project_id를 이용하여 project를 찾아서 project에 대입한 후 request에 저장
		ProjectManager manager = ProjectManager.getInstance();
		Project project = manager.findProject(projectId);
		
		if(project == null) {
			request.setAttribute("no_project", true);
			return "/project/projectSupport.jsp";
		}
		
		ProjectDTO projectDTO = manager.findProjectInfo(project);
		List<ProjectNoticeDTO> noticeList = manager.getNoticeList(projectId);
		
		HttpSession session = request.getSession();   
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		SupportDTO supportDTO = new SupportDTO(ecoerId, projectId);
		boolean isSupport = manager.isSupportProject(supportDTO);
		
		InterestProjectDTO interestDTO = new InterestProjectDTO(ecoerId, projectId);
		boolean isInterest = manager.isInterestProject(interestDTO);

    	request.setAttribute("project", project);
    	request.setAttribute("projectDTO", projectDTO);
    	request.setAttribute("noticeList", noticeList);
    	request.setAttribute("isSupport", isSupport);
    	request.setAttribute("isInterest", isInterest);
    	
		return "/project/projectSupport.jsp";
	}
}
