package controller.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;
import model.service.dto.ProjectDTO;

public class SearchProjectController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * String currentPageStr = request.getParameter("currentPage"); int currentPage
		 * = 1; if (currentPageStr != null && !currentPageStr.equals("")) { currentPage
		 * = Integer.parseInt(currentPageStr); }
		 */
		String keyword = request.getParameter("keyword");
		try {
			List<Project> projectList = new ArrayList<Project>();
			ProjectManager manager = ProjectManager.getInstance();
			HashMap<Project, Integer> projectMap = new HashMap<Project, Integer>();
			
			if (keyword != null) { // 검색 키워드가 있다면
				projectList = manager.findProjectListByKeyword(keyword);
				for (Project p : projectList) {
					ProjectDTO projectDTO = manager.findProjectInfo(p);
					int percent = projectDTO.getPricePercent();
					projectMap.put(p, percent);
				}
				
				// projectMap 객체를 request에 저장하여 전달
				// request.setAttribute("projectList", projectList);
				request.setAttribute("projectMap", projectMap);
				// 검색 결과로 이동(forwarding)
				return "/view/searchResult.jsp"; // Foward
			}
		}
		catch(Exception e) {
            request.setAttribute("searchFailed", true);
			request.setAttribute("exception", e);
            return "/view/searchResult.jsp";			
		}
		return null;
	}
}
