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
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("code"),
			request.getParameter("address"),
			request.getParameter("detailAddress"),
			request.getParameter("phone"),
			request.getParameter("email"),
			false);
		
        log.debug("Create Ecoer : {}", ecoer);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(ecoer);
	        return "/user/registerDone.jsp"; //회원가입이 완료되었다는 페이지 표시(211121 17:48:18 추가)
	        
		} catch (ExistingUserException e) {	
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("ecoer", ecoer);
			return "/user/registerForm.jsp";
		}
    }
}
