package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;

public class NoticeRegisterController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		ProjectManager manager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			request.setAttribute("projectId", projectId);
			return "/project/notice/registerNotice.jsp";
		}
		
		String content = request.getParameter("content");
		
		ProjectNoticeDTO notice = new ProjectNoticeDTO(projectId, content);
		manager.createNotice(notice);
		
		return "redirect:/project/notice?projectId=" + projectId;
	}

}
