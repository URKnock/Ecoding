package controller.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CommunityManager;
import model.service.dto.CommunityDTO;

public class CreateCommunityController implements Controller {
//    private static final Logger log = (Logger) LoggerFactory.getLogger(CreateCommunityController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	int id = Integer.parseInt(request.getParameter("id"));
    	CommunityDTO comm = new CommunityDTO(id, request.getParameter("name"));
        
		try {
			CommunityManager manager = CommunityManager.getInstance();
			manager.insert(comm);
			return "redirect:/board/postList.jsp";
			
		} catch (Exception e) {
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("comm", comm);
			return "/board/postList.jsp";
		}
    }
}
