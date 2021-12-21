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

public class SupportUpdateController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int supportId = Integer.parseInt(request.getParameter("supportId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
 		
 		if (request.getMethod().equals("GET")) {
 			request.setAttribute("supportId", supportId);
 			request.setAttribute("projectId", projectId);
 		
 			return "/user/project/updateSupport.jsp";
 		}
 		
 		String card = request.getParameter("card");
 		String bank = request.getParameter("bank");
 		
 		ProjectManager manager = ProjectManager.getInstance();
 		
 		SupportDTO supportDTO = new SupportDTO();
 		supportDTO.setSupportId(supportId);
 		supportDTO.setCard(card);
 		supportDTO.setBank(bank);
 		
 		manager.updateSupport(supportDTO);

 		return "redirect:/user/project/support/view?projectId=" + projectId;
	}
}
