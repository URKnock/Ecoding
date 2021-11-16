package controller.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;

public class UpdateCommunityController implements Controller {
   // private static final Logger log = LoggerFactory.getLogger(UpdateCommunityController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	/*
		int commId = Integer.parseInt(request.getParameter("commId"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: Ŀ�´�Ƽ ���� form ��û	
    		UserManager manager = UserManager.getInstance();
			Community comm = manager.findCommunity(commId);	// �����Ϸ��� Ŀ�´�Ƽ ���� �˻�
			request.setAttribute("community", comm);			
			
			List<User> members = manager.findCommunityMembers(commId); // Ŀ�´�Ƽ ȸ�� ����Ʈ �˻�
			request.setAttribute("members", members);		
			return "/community/updateForm.jsp";   // �˻��� ������ update form���� ����     
	    }	
    	
    	// POST request (Ŀ�´�Ƽ ������ parameter�� ���۵�)
    	Community comm = new Community(
    		commId,
    		request.getParameter("name"),
    		request.getParameter("desc"),
    		null, request.getParameter("chairId"), null);

    	log.debug("Update Community : {}", comm);

		UserManager manager = UserManager.getInstance();
		manager.updateCommunity(comm);
		*/		
        return "redirect:/community/list";			
    }
}
