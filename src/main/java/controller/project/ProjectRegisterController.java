package controller.project;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Project;
import model.Reward;
import model.service.CreatorManager;
import model.service.ProjectManager;
import model.service.UserManager;
import model.service.dto.CreatorDTO;

//image, video 등 file 다 빠져있음
public class ProjectRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String step = request.getParameter("step");
    	HttpSession session = request.getSession();		
    	
    	if(step.equals("step1")) {    
    		if(UserSessionUtils.hasLogined(session))
    			return "/project/registerProjectForm_step1.jsp";
    		else
    			return "redirect:/user/loginform";
    	}
    	else if(step.equals("step2")) {
    		Project project = null; 
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		try {
    			project = new Project(-1, null, request.getParameter("title"), null, request.getParameter("simpleInfo"), 
        				request.getParameter("category"), request.getParameter("hashtag"), request.getParameter("ecotag"), 0, 
        				Integer.parseInt(request.getParameter("targetAmount")), 0, sdf.parse(request.getParameter("startDate")), 
        				sdf.parse(request.getParameter("endDate")), sdf.parse(request.getParameter("payDate")), 
        				sdf.parse(request.getParameter("deliveryDate")), null, null, null, null, null);	
    			
    			session.setAttribute("project", project);
    			return "/project/registerProjectForm_step2.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		return "/project/registerProjectForm_step1.jsp";
        	}      
    	}
    	else if(step.equals("step3")) {
    		String ecoerId = UserSessionUtils.getLoginEcoerId(session);	
    		Project project =  (Project)session.getAttribute("project");
    		
			
    		try {
    			project.setEcoerId(ecoerId);
    			project.setDetailInfo(request.getParameter("detailInfo"));
    			project.setPlanInfo(request.getParameter("planInfo"));
    			project.setExchangeInfo(request.getParameter("exchangeInfo"));
    			
	    		Reward reward = new Reward(-1, -1, request.getParameter("name"), 
	    				Integer.parseInt(request.getParameter("reward_price")), request.getParameter("reward_info"));
	    		
	    		UserManager manager = UserManager.getInstance();
	    		boolean check = manager.findEcoer(ecoerId).getIsCreator();

	    		session.setAttribute("project", project);
	    		session.setAttribute("reward", reward);
	    		request.setAttribute("isCre", check);
				return "/project/registerProjectForm_step3.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		session.setAttribute("project", project);
        		return "/project/registerProjectForm_step2.jsp";
        	}      
    	}
    	else if(step.equals("step4")) {
    		Project project =  (Project)session.getAttribute("project");
    		Reward reward =  (Reward)session.getAttribute("reward");
    		
    		try {
    			CreatorDTO creator = new CreatorDTO(project.getEcoerId(), request.getParameter("teamName"), null, 
    					request.getParameter("teamDetail"), request.getParameter("account"));
    			
    			CreatorManager cmanager = CreatorManager.getInstance();
    			cmanager.update(creator);
    			
    			session.setAttribute("project", project);
    			session.setAttribute("reward", reward);
    			return "/project/registerProjectForm_step4.jsp";
    		} catch (Exception e) {
    			request.setAttribute("registerFailed", true);
    			request.setAttribute("exception", e);
    			session.setAttribute("project", project);
    			session.setAttribute("reward", reward);
    			return "/project/registerProjectForm_step3.jsp";
    		}
    	}
    	else if(step.equals("final")) {
			Project project =  (Project)session.getAttribute("project");
			Reward reward =  (Reward)session.getAttribute("reward");
			CreatorDTO creator =  (CreatorDTO)session.getAttribute("creator");
    		
    		try {
    			ProjectManager manager = ProjectManager.getInstance();
    			int projectId = manager.registerProject(project);
				
    			reward.setProject_id(projectId);
	    		manager.createReward(reward);
	    		
    			session.removeAttribute("project");
    			session.removeAttribute("reward");
    			return "/project/successRegister.jsp";
    		} catch (Exception e) {
    			request.setAttribute("registerFailed", true);
    			request.setAttribute("exception", e);
				return "/project/registerStart.jsp";
    		}
    	}
    	else {
    		return "/project/registerStart.jsp";    		
    	}
    }
}