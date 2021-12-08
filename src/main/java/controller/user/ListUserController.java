package controller.user;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.service.UserManager;
import model.service.dto.EcoerDTO;

public class ListUserController implements Controller {
	// private static final int countPerPage = 100;	// �� ȭ�鿡 ����� ����� ��

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/loginform";		// login form ��û���� redirect
        }
    	
    	/*
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	*/
    	
		UserManager manager = UserManager.getInstance();
		List<EcoerDTO> ecoerList = manager.getEcoerList();
		// List<User> userList = manager.findUserList(currentPage, countPerPage);

		// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("ecoerList", ecoerList);				
		request.setAttribute("curEcoerId", 
				UserSessionUtils.getLoginEcoerId(request.getSession()));		

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/user/list.jsp"; //list 안 씀 ==> admin 페이지로 대체?      
    }
}
