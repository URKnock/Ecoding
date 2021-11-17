package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import controller.Controller;
//import model.service.dto.ProjectDTO;

public class ProjectRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	String step = request.getParameter("step");
    	
    	if(step.equals("step1")) {
    		return "/project/registerProjectForm_step1.jsp";
    	}
    	else if(step.equals("step2")) {
    		return "/project/registerProjectForm_step2.jsp";
    	}
    	else if(step.equals("step3")) {
    		return "/project/registerProjectForm_step3.jsp";
    	}
    	else if(step.equals("step4")) {
    		return "/project/registerProjectForm_step4.jsp";
    	}
    	else if(step.equals("final")) {
    		return "/project/successRegister.jsp";
    	}
    	else {
    		return "/project/registerStart.jsp";    		
    	}
    }
}
