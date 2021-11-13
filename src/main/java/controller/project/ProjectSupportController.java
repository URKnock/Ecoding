package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
//import model.Community;
//import model.service.UserManager;

import model.*;
import model.service.ProjectManager;

import java.util.*;

public class ProjectSupportController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		int project_id = (int) request.getAttribute("project_id");
		ProjectManager manager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) { // GET 프로젝트 옵션 선택 페이지로
		
			// project_id 통해서 project와 reward 테이블 조인후 reward리스트 반환받는다.
			List<Reward> rewardList = manager.findRewardList(project_id);
			
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("project_id", project_id);
			
			return "/projectSupportForm.jsp";
		}
		
		// POST 프로젝트 최종 확인 폼으로
		
		// 리워드 아이디 넘어오면 id로 리워드 검색후 저장 or 리워드 객체를 저장된걸 넘겨받기?
		int reward_id = Integer.parseInt(request.getParameter("reward"));
		int addPrice = Integer.parseInt(request.getParameter("addPrice"));
		
		Reward reward = manager.findReward(reward_id);
		
		Project project = manager.findProject(project_id);
		
		// user_id를 이용해 user 찾은 후 user객체 생성후 저장
		//String user_id = session.getAttribute("user_id");
		//User user = null;
		
		//request.setAttribute("user", user);
		request.setAttribute("reward", reward);
		request.setAttribute("add", addPrice);
		request.setAttribute("project", project);
		
		return "/projectSupportConfirmForm.jsp";
	}

}
