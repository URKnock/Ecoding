package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Project;
import model.service.ProjectManager;
import model.service.dto.InterestProjectDTO;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;
import model.service.dto.SupportDTO;

public class ProjectInterestController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		HttpSession session = request.getSession();
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		ProjectManager manager = ProjectManager.getInstance();
		
		InterestProjectDTO interestDTO = new InterestProjectDTO(ecoerId, projectId);
		boolean isInterest = manager.isInterestProject(interestDTO);
		
		if (isInterest == false) {
			manager.insertInterestProject(interestDTO);
		} else {
			manager.removeInterestProject(interestDTO);
		}

		return "redirect:/project/support/view?projectId=" + projectId;
	}
}
