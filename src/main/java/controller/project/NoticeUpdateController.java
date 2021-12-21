package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;
import model.service.dto.ProjectNoticeDTO;

public class NoticeUpdateController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		
		ProjectManager manager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			
			ProjectNoticeDTO noticeDTO = manager.findNoticeById(noticeId);
			request.setAttribute("notice", noticeDTO);

			request.setAttribute("projectId", projectId);
			
			return "/project/notice/updateNotice.jsp";
		}
		
		String content = request.getParameter("content");
		
		ProjectNoticeDTO notice = new ProjectNoticeDTO();
		notice.setNoticeId(noticeId);
		notice.setNoticeContent(content);
		
		manager.updateNotice(notice);
		
		return "redirect:/project/notice?projectId=" + projectId;
	}
		
}
