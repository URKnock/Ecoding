package controller.project;

import java.text.SimpleDateFormat;
import java.util.List;

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
import model.service.dto.RewardDTO;

//image, video 등 file 다 빠져있음
public class ProjectRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String step = request.getParameter("step");
    	HttpSession session = request.getSession();		
    	
    	if(step.equals("step1")) {    
    		if(UserSessionUtils.hasLogined(session)) {
    			Project project = new Project();
    			if(request.getParameter("projectId") != null) {
    				int projectId = Integer.parseInt(request.getParameter("projectId"));
    				ProjectManager manager = ProjectManager.getInstance();
    				project = manager.findProject(projectId);
    				
    				/*리워드 수정 가능하게 할거면 주석 풀고 코드 추가
    				List<RewardDTO> rewardList = manager.getRewardList(projectId);
    				
    				request.setAttribute("rewardList", rewardList);
    				*/
    			}
    			else
    				project.setProjectId(-1);
    			
    			session.setAttribute("project", project);
    			
    			return "/project/registerProjectForm_step1.jsp";
    		}
    		else
    			return "redirect:/user/loginform";
    	}
    	else if(step.equals("step2")) {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Project project = null;
    		try {
    			if(request.getParameter("projectId") != "-1")
    				project = (Project)session.getAttribute("project");
    			else
    				project = new Project();
    			
    			project.setProjectId(Integer.parseInt(request.getParameter("projectId")));
    			project.setTitle(request.getParameter("title"));
    			project.setSimpleInfo(request.getParameter("simpleInfo"));
    			project.setCategory(request.getParameter("category"));
    			project.setHashTag("#" + request.getParameter("hashtag"));
    			project.setEcoTag(request.getParameter("ecotag"));
    			project.setTargetPrice(Integer.parseInt(request.getParameter("targetAmount")));
    			project.setStartDate(sdf.parse(request.getParameter("startDate")));
    			project.setEndDate(sdf.parse(request.getParameter("endDate")));
    			project.setPaymentDate(sdf.parse(request.getParameter("payDate")));
    			project.setDeliveryDate(sdf.parse(request.getParameter("deliveryDate")));
    			
    			String[] name = request.getParameterValues( "name" );
    			String[] rewardName = request.getParameterValues( "reward_price" );
    			String[] info = request.getParameterValues( "reward_info" );
				
    			if(project.getProjectId() == -1) {
					Reward[] reward = new Reward[name.length];
					
					for(int i = 0; i < name.length; i++)
						reward[i] = new Reward(-1, -1, name[i], Integer.parseInt(rewardName[i]), info[i]);
					
					session.setAttribute("reward", reward);
    			}
    			
    			session.setAttribute("project", project);
    			return "/project/registerProjectForm_step2.jsp";
    		} catch (Exception e) {
        		request.setAttribute("registerFailed", true);
        		request.setAttribute("exception", e);
        		return "/project/registerProjectForm_step1.jsp";
        	}      
    	}
    	else if(step.equals("final")) {
			Project project =  (Project)session.getAttribute("project");
			ProjectManager manager = ProjectManager.getInstance();
			
    		try {
    			if(project.getProjectId() != -1) {
    				manager.updateProject(project);
    			}
    			else {
	    			int projectId = manager.registerProject(project);
					
	    			Reward[] reward =  (Reward[])session.getAttribute("reward");
	    			
	    			for(int i = 0; i < reward.length; i++)
	    				reward[i].setProject_id(projectId);
		    		manager.createReward(reward);
		    		
		    		session.removeAttribute("reward");
    			}
    			
    			session.removeAttribute("project");
    			return "/project/successRegister.jsp";
    		} catch (Exception e) {
    			request.setAttribute("registerFailed", true);
    			request.setAttribute("exception", e);
				return "/project/registerStart.jsp";
    		}
    	}
    	else if(step.equals("delete")) {
    		int projectId = Integer.parseInt(request.getParameter("projectId"));
			ProjectManager manager = ProjectManager.getInstance();
			manager.removeProject(projectId);
			
			return "redirect:/user/project/listView";
    	}
    	else {
    		return "/project/registerStart.jsp";    		
    	}
    }
}