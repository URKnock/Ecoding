package controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        				request.getParameter("category"), request.getParameterValues("hashtag"), request.getParameterValues("ecotag"), 
        				Integer.parseInt(request.getParameter("targetAmount")), sdf.parse(request.getParameter("startDate")), sdf.parse(request.getParameter("endDate")),
    					sdf.parse(request.getParameter("payDate")), sdf.parse(request.getParameter("deliveryDate")));
    			ProjectManager manager = ProjectManager.getInstance();
    			manager.registerProject(project);
    			return "/project/registerProjectForm_step2.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		request.setAttribute("project", project);
        		return "/project/registerProjectForm_step1.jsp";
        	}      
    	}
    	else if(step.equals("step3")) {
    		Project project = new Project(request.getParameter("detailInfo"), request.getParameter("planInfo"), request.getParameter("exchangeInfo"), request.getParameter("projectVideo"), 
    				request.getParameter("projectFile"));
    		
    		Reward reward = new Reward(request.getParameter("reward"), Integer.parseInt(request.getParameter("rewardPrice")));

			ProjectManager manager = ProjectManager.getInstance();
			manager.updateProject(project);
			request.setAttribute("project", project);
			request.setAttribute("reward", reward);
			return "/project/registerProjectForm_step3.jsp";
    	}
    	else if(step.equals("step4")) {
    		CreatorDTO creator = new CreatorDTO(request.getParameter("teamName"), request.getParameter("teamImage"), request.getParameter("teamDetail"), request.getParameter("account"));
    		
    		try {
    			CreatorManager manager = CreatorManager.getInstance();
    			manager.update(creator);
    			request.setAttribute("creator", creator);
    			return "/project/registerProjectForm_step4.jsp";
    		} catch (Exception e) {
    			request.setAttribute("registerFailed", true);
    			request.setAttribute("exception", e);
    			return "/project/registerProjectForm_step3.jsp";
    		}
    	}
    	else if(step.equals("final")) {
    		return "/project/successRegister.jsp";
    	}
    	else {
    		return "/project/registerStart.jsp";    		
    	}
    }
}
