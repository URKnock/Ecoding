package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.CreatorManager;
import model.service.UserManager;
import model.service.dto.CreatorDTO;
import model.service.dto.EcoerDTO;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ���� form ��û	
    		// ������ UpdateUserFormController�� ó���ϴ� �۾��� ���⼭ ����
    		String updateId = request.getParameter("ecoerId");

    		log.debug("UserUpdate Request : {}", updateId);
    		
    		UserManager manager = UserManager.getInstance();
    		EcoerDTO ecoer = manager.findEcoer(updateId);	// �����Ϸ��� ����� ���� �˻�
			request.setAttribute("ecoer", ecoer);			
			
			if(ecoer.getIsCreator()) {
    			CreatorManager cmanager = CreatorManager.getInstance();
    			CreatorDTO creator = cmanager.findCreator(updateId);
    			request.setAttribute("creator", creator);
    		}
			
			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(updateId, session) ||
				UserSessionUtils.isLoginUser("admin", session)) {
				// ���� �α����� ����ڰ� ���� ��� ������̰ų� �������� ��� -> ���� ����
				
				return "/user/userUpdate.jsp";     
			}    
			
			// else (���� �Ұ����� ���) ����� ���� ȭ������ ���� �޼����� ����
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("정보를 수정할 수 없습니다."));            
			return "/user/userView.jsp";	// ����� ���� ȭ������ �̵� (forwarding)
	    }	
    	
    	// POST request (ȸ�������� parameter�� ���۵�)
       	EcoerDTO updateEcoer = new EcoerDTO(
			request.getParameter("ecoerId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("code"),
			request.getParameter("address"),
			request.getParameter("detailAddress"),
			request.getParameter("phone"),
			request.getParameter("email"),
			Boolean.parseBoolean(request.getParameter("isCreator"))
			);

    	log.debug("Update Ecoer : {}", updateEcoer);

    	HttpSession session = request.getSession(); //세션에 사용자 아이디 저장
        session.setAttribute(UserSessionUtils.USER_SESSION_KEY, updateEcoer.getEcoerId());
    	
		UserManager manager = UserManager.getInstance();
		manager.update(updateEcoer);	
		CreatorDTO creator = new CreatorDTO(request.getParameter("ecoerId"), 
				request.getParameter("teamName"), 
				request.getParameter("teamImage"), 
				request.getParameter("teamInfo"), 
				request.getParameter("account"));
		CreatorManager cmanager = CreatorManager.getInstance();
		cmanager.update(creator);
        return "redirect:/user/view";
    }
}
