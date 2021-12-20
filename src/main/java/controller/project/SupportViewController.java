package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProjectManager;
import model.service.UserManager;
import model.service.dto.EcoerDTO;
import model.service.dto.ProjectDTO;
import model.service.dto.RewardDTO;
import model.service.dto.SupportDTO;

public class SupportViewController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		HttpSession session = request.getSession();   
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		ProjectManager manager = ProjectManager.getInstance();
		UserManager uManager = UserManager.getInstance();
		
		SupportDTO support = manager.findSupport(ecoerId, projectId);
		ProjectDTO project = manager.findProjectSimpleInfo(projectId);
		RewardDTO reward = manager.findReward(support.getRewardId());
		EcoerDTO ecoer = uManager.findEcoer(ecoerId);
		
		request.setAttribute("support", support);
		request.setAttribute("project", project);
		request.setAttribute("reward", reward);
		request.setAttribute("ecoer", ecoer);
		
		return "/user/project/supportView.jsp";
	}

}
