package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ExistingUserException;
import model.service.UserManager;
import model.service.dto.EcoerDTO;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request 처리 (회원가입 폼 호출)
    		log.debug("RegisterForm Request");
		
			return "/user/registerForm.jsp";   	
	    }	

    	// POST request 처리 (신규 등록) ==> 신규 유저는 창작자 off
       	EcoerDTO ecoer = new EcoerDTO(
			request.getParameter("ecoerId"),
			request.getParameter("name"),
			request.getParameter("address"),
			request.getParameter("phone"),
			request.getParameter("email"),
			request.getParameter("password"), false);
		
        log.debug("Create Ecoer : {}", ecoer);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(ecoer);
	        return "redirect:/user/list"; //listing 기능을 사용할 것인가? ==> forwarding으로 완료 화면을 보여주는 게 어떨지?
	        
		} catch (ExistingUserException e) {	
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("ecoer", ecoer);
			return "/user/registerForm.jsp";
		}
    }
}
