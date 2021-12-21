package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;

public class PostFormController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		ProjectManager manager = ProjectManager.getInstance();

		List<ProjectDTO> projectList = manager.supportProjectInfoList(ecoerId);
		List<ProjectDTO> myProjectInfoList = manager.myProjectInfoList(ecoerId);
		projectList.addAll(myProjectInfoList);
		
		request.setAttribute("projectList", projectList);
		return "/board/postForm.jsp";

	}
}