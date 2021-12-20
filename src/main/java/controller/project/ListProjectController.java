package controller.project;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class ListProjectController implements Controller {
	// private static final int countPerPage = 100;	// 한 화면에 출력할 프로젝트 수
	 private String forwardUrl;

	    public ListProjectController(String forwardUrl) {
	        if (forwardUrl == null) {
	            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
	        }
	        this.forwardUrl = forwardUrl;
	    }

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/resources/img");
		File dir = new File(path);
    	/*
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	*/
    	
    	ProjectManager manager = ProjectManager.getInstance();
    	List<Project> projectList = manager.findProjectList();
		// List<Project> projectList = manager.findProjectList(currentPage, countPerPage);

		// projectList 객체를 request에 저장하여 전달
		request.setAttribute("projectList", projectList);				
		request.setAttribute("dir", dir);
		// 홈 화면 또는 둘러보기 화면으로 이동(forwarding)
		return forwardUrl; //구현을 FowardController처럼
    }
}
