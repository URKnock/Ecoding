package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;

public class SupportDeleteController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int supportId = Integer.parseInt(request.getParameter("supportId"));
		
		ProjectManager manager = ProjectManager.getInstance();
		manager.deleteSupport(supportId);
		
		// 후원한 프로젝트 리스트로 넘어가기, 정보 넘기기
		
		
		HttpSession session = request.getSession();
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);

		List<ProjectDTO> supportProjectInfoList = manager.supportProjectInfoList(ecoerId);
		request.setAttribute("supportList", supportProjectInfoList);
		
		return "/user/project/supportProjectListView.jsp";
	}
}
