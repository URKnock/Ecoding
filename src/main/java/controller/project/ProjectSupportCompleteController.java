package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;
import model.Support;
import model.service.dto.ProjectDTO;
import model.service.dto.SupportDTO;

public class ProjectSupportCompleteController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		String ecoerId = request.getParameter("ecoerId");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String bank = request.getParameter("bank");
		String card = request.getParameter("card");
		
		SupportDTO support = new SupportDTO(ecoerId, projectId, rewardId, amount, bank, card);
		
		ProjectManager manager = ProjectManager.getInstance();
		
		manager.supportProject(support);
		
		// 프로젝트 아이디로 제목을 찾은 후 저장 -> 출력할 타이틀
		ProjectDTO project = manager.findProjectSimpleInfo(projectId); // or projectId
		request.setAttribute("project", project);
		
		return "/project/projectSupportComplete.jsp";
	}
}
