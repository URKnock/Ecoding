package controller.project;
import model.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.*;
import model.service.ProjectManager;

public class ProjectSupportCompleteController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		// 후원하기 파라미터로 받기 or 객체로 받기?
		
		int project_id = (int) request.getAttribute("project_id");
		int user_id = (int) request.getAttribute("user_id");
		String reward_id = (String) request.getAttribute("reward_id");
		String amount = (String) request.getAttribute("amount"); // 리워드가격+추가후원금액
		String cardBank = (String) request.getAttribute("cardBank");
		String cardNum = (String) request.getAttribute("cardNum");
		
		
		// 아래사항들 매니저에서 묶기도 가능
		
		// order 테이블에 정보추가
		ProjectManager manager = ProjectManager.getInstance();
		manager.supportProject();
		
		// project 정보 수정 : 후원 총 금액 증가
		
		// user에도 정보추가?
		
		
		// 프로젝트 아이디로 제목을 찾은 후 저장 -> 출력할 타이틀
		String projectTitle = null;
		request.setAttribute("projectTitle", projectTitle);
		
		return "/projectSupportComplete.jsp";
	}
}
