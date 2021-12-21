package controller.project;

import java.util.List;

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

public class SupportRewardUpdateController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int supportId = Integer.parseInt(request.getParameter("supportId"));
		 	
		ProjectManager manager = ProjectManager.getInstance();

		if (request.getMethod().equals("GET")) {
			List<RewardDTO> rewardList = manager.getRewardList(projectId);
				
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("projectId", projectId);
			request.setAttribute("supportId", supportId);
		 		
			return "/user/project/rewardUpdate.jsp";
		 }
		 	
		 int rewardId = Integer.parseInt(request.getParameter("reward"));
		 int addPrice = Integer.parseInt(request.getParameter("addPrice"));
		 	
		 SupportDTO supportDTO = new SupportDTO();
		 supportDTO.setSupportId(supportId);
		 supportDTO.setProjectId(projectId);
		 supportDTO.setRewardId(rewardId);
		 	
		 manager.updateRewardSupport(supportDTO, addPrice);
		 	
		 return "redirect:/user/project/support/view?projectId=" + projectId;
	}
}
