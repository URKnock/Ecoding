package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProjectManager;
import model.service.UserManager;
import model.service.dto.*;

import java.util.List;

public class ProjectSupportController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		ProjectManager manager = ProjectManager.getInstance();
		UserManager uManager = UserManager.getInstance();
		
		if (request.getMethod().equals("GET")) { // GET 프로젝트 옵션 선택 페이지로
			// projectId reward리스트 반환받는다.
			List<RewardDTO> rewardList = manager.getRewardList(projectId);
			
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("projectId", projectId);

			return "/project/projectSupportForm.jsp";
		}
		
		// POST 프로젝트 최종 확인 폼으로
		int rewardId = Integer.parseInt(request.getParameter("reward"));
		int addPrice = Integer.parseInt(request.getParameter("addPrice"));
		
		RewardDTO reward = manager.findReward(rewardId);
		
		ProjectDTO project = manager.findProjectSimpleInfo(projectId);
		
		HttpSession session = request.getSession();   
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		EcoerDTO ecoer = uManager.findEcoer(ecoerId);
		
		request.setAttribute("ecoer", ecoer);
		request.setAttribute("project", project);
		request.setAttribute("reward", reward);
		request.setAttribute("add", addPrice);
		
		return "/project/projectSupportConfirmForm.jsp";
	}

}
