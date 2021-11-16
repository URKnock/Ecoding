package controller.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import controller.Controller;
import model.service.UserManager;

public class CreateCommunityController implements Controller {
    private static final Logger log = (Logger) LoggerFactory.getLogger(CreateCommunityController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Community comm = new Community(
    		0, request.getParameter("name"),
			request.getParameter("desc"),
			null, null, null);		
        
		try {
			UserManager manager = UserManager.getInstance();
			manager.createCommunity(comm);
			
	    	log.debug("Create Community : {}", comm);
	        return "redirect:/community/list";	// ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
	        
		} catch (Exception e) {		// ���� �߻� �� �Է� form���� forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("comm", comm);
			return "/community/creationForm.jsp";
		}
    }
}
