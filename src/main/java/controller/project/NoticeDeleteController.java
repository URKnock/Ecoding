package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;

public class NoticeDeleteController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		ProjectManager manager = ProjectManager.getInstance();
		manager.deleteNotice(noticeId);
		
		return "redirect:/project/notice?projectId=" + projectId;
		
	}
}
