package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CreatorManager;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.service.dto.CreatorDTO;
import model.service.dto.EcoerDTO;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/loginform";		// login form으로 redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String ecoerId = request.getParameter("ecoerId");
		
    	EcoerDTO ecoer = null;
    	try {
    		ecoer = manager.findEcoer(ecoerId);
    		
    		if(ecoer.getIsCreator()) {
    			CreatorManager cmanager = CreatorManager.getInstance();
    			CreatorDTO creator = cmanager.findCreator(ecoerId);
    			request.setAttribute("creator", creator);
    		}
		} catch (UserNotFoundException e) {				
	        return "redirect:/home/main";
		}	
		
    	request.setAttribute("ecoer", ecoer);				
		return "/user/userView.jsp";
    }
}
