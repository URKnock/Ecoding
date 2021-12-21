package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;

public class NoticeController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		ProjectManager manager = ProjectManager.getInstance();

		List<ProjectNoticeDTO> noticeList = manager.getNoticeList(projectId);
		request.setAttribute("noticeList", noticeList);
			
		ProjectDTO project = manager.findProjectSimpleInfo(projectId);
		request.setAttribute("project", project);

		return "/project/notice/viewNotice.jsp";
		
	}
}
