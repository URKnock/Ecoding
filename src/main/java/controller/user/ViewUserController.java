package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
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
		} catch (UserNotFoundException e) {				
	        return "redirect:/home/main";
		}	
		
    	request.setAttribute("ecoer", ecoer);				
		return "/user/userView.jsp";
    }
}
