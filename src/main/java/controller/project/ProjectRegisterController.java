package controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import controller.Controller;
import model.Project;
import model.Reward;
import model.service.CreatorManager;
import model.service.PostManager;
import model.service.ProjectManager;
import model.service.dto.CreatorDTO;
import model.service.dto.PostDTO;
import model.service.dto.ProjectDTO;

//image, video 암튼 file 다 빠져있음
public class ProjectRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String step = request.getParameter("step");
    	
    	if(step.equals("step1")) {    		
    		return "/project/registerProjectForm_step1.jsp";
    	}
    	else if(step.equals("step2")) {
    		Project project = null; 
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		try {
    			project = new Project(request.getParameter("title"), request.getParameter("simpleInfo"), 
        				request.getParameter("category"), request.getParameter("hashtag"), request.getParameter("ecotag"), 
        				Integer.parseInt(request.getParameter("targetAmount")), sdf.parse(request.getParameter("startDate")), sdf.parse(request.getParameter("endDate")),
    					sdf.parse(request.getParameter("payDate")), sdf.parse(request.getParameter("deliveryDate")), null, null, null);	
    			request.setAttribute("project", project);
    			return "/project/registerProjectForm_step2.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		return "/project/registerProjectForm_step1.jsp";
        	}      
    	}
    	else if(step.equals("step3")) {
    		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    		Project project = new Project(request.getParameter("project"), request.getParameter("simpleInfo"), 
    				request.getParameter("category"), request.getParameter("hashtag"), request.getParameter("ecotag"), 
    				Integer.parseInt(request.getParameter("targetAmount")), sdf.parse(request.getParameter("startDate")), sdf.parse(request.getParameter("endDate")),
					sdf.parse(request.getParameter("payDate")), sdf.parse(request.getParameter("deliveryDate")), null, null, null);
			
    		try {
    			project.setDetailInfo(request.getParameter("detailInfo"));
    			project.setPlanInfo(request.getParameter("planInfo"));
    			project.setExchangeInfo(request.getParameter("exchangeInfo"));
    			
	    		Reward reward = new Reward(request.getParameter("name"), Integer.parseInt(request.getParameter("reward_price")), request.getParameter("reward_info"));

				request.setAttribute("project", project);
				request.setAttribute("reward", reward);
				return "/project/registerProjectForm_step3.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		request.setAttribute("project", project);
        		return "/project/registerProjectForm_step2.jsp";
        	}      
    	}
    	else if(step.equals("step4")) {
    		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    		Project project = new Project(request.getParameter("title"), request.getParameter("simpleInfo"), 
    				request.getParameter("category"), request.getParameter("hashtag"), request.getParameter("ecotag"), 
    				Integer.parseInt(request.getParameter("targetAmount")), sdf.parse(request.getParameter("startDate")), 
    				sdf.parse(request.getParameter("endDate")), sdf.parse(request.getParameter("payDate")), 
    				sdf.parse(request.getParameter("deliveryDate")), request.getParameter("detailInfo"), 
    				request.getParameter("planInfo"), request.getParameter("exchangeInfo"));
    		Reward reward = new Reward(request.getParameter("name"), Integer.parseInt(request.getParameter("reward_price")), request.getParameter("reward_info"));
    		
    		try {
    			CreatorDTO creator = new CreatorDTO(request.getParameter("ecoerId"), request.getParameter("teamName"), 
    					request.getParameter("teamDetail"), request.getParameter("account"));
    			
    			request.setAttribute("project", project);
				request.setAttribute("reward", reward);
    			request.setAttribute("creator", creator);
    			return "/project/registerProjectForm_step4.jsp";
    		} catch (Exception e) {
    			request.setAttribute("registerFailed", true);
    			request.setAttribute("exception", e);
    			request.setAttribute("project", project);
				request.setAttribute("reward", reward);
    			return "/project/registerProjectForm_step3.jsp";
    		}
    	}
    	else if(step.equals("final")) {
    		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    		Project project = new Project(request.getParameter("title"), request.getParameter("simpleInfo"), 
    				request.getParameter("category"), request.getParameter("hashtag"), request.getParameter("ecotag"), 
    				Integer.parseInt(request.getParameter("targetAmount")), sdf.parse(request.getParameter("startDate")), 
    				sdf.parse(request.getParameter("endDate")), sdf.parse(request.getParameter("payDate")), 
    				sdf.parse(request.getParameter("deliveryDate")), request.getParameter("detailInfo"), 
    				request.getParameter("planInfo"), request.getParameter("exchangeInfo"));
			
    		Reward reward = new Reward(-1, request.getParameter("name"), Integer.parseInt(request.getParameter("reward_price")), request.getParameter("reward_info"));
    		
    		CreatorDTO creator = new CreatorDTO(request.getParameter("ecoerId"), request.getParameter("teamName"), 
					request.getParameter("teamDetail"), request.getParameter("account"));
    		
    		try {
    			ProjectManager manager = ProjectManager.getInstance();
    			int projectId = manager.registerProject(project);
				
    			reward.setProject_id(projectId);
	    		manager.createReward(reward);
	    		
    			CreatorManager cmanager = CreatorManager.getInstance();
    			cmanager.update(creator);
				
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
