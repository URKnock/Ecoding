package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String ecoerId = request.getParameter("ecoerId");
		String password = request.getParameter("password");
		
		try {
			UserManager manager = UserManager.getInstance();
			manager.login(ecoerId, password);
	
			HttpSession session = request.getSession(); //세션에 사용자 아이디 저장 ==> jsp에서 꺼내쓰기
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, ecoerId);
            
            return "redirect:/home/main"; //혹은 직전에 있었던 페이지로 		
		} catch (Exception e) {
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/loginForm.jsp";			
		}	
    }
}
