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
    	// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form으로 redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String ecoerId = request.getParameter("ecoerId");

    	EcoerDTO ecoer = null;
    	try {
    		ecoer = manager.findEcoer(ecoerId);
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/list"; //리스트 사용 안 할 것 같음
		}	
		
    	request.setAttribute("ecoer", ecoer);				
		return "/user/view.jsp";				//새로 작성한 페이지로 교체하기
    }
}
