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
		
		HttpSession session = request.getSession();		
		session.setAttribute("projectId", projectId);
		
//		// 다시 정보 저장해서 넘기기
//		List<ProjectNoticeDTO> noticeList = manager.getNoticeList(projectId);
//		request.setAttribute("noticeList", noticeList);
//
//		ProjectDTO project = manager.findProjectSimpleInfo(projectId);
//		request.setAttribute("project", project);
		
		
//		return "/project/notice/viewNotice.jsp";
//		return "redirect:/project/notice/registerNotice";
		return "redirect:/project/notice?projectId=" + projectId;
	}

}
