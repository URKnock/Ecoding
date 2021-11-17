package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReplyManager;
import model.service.dto.ReplyDTO;

public class CreateReplyController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		ReplyDTO reply = (ReplyDTO) request.getAttribute("reply");
    	try {
    		ReplyManager manager = ReplyManager.getInstance();
    		manager.insert(reply);
    		return "redirect:/board/view";
    	} catch (Exception e) {
    		request.setAttribute("replyFailed", true);
    		request.setAttribute("exception", e);
    		request.setAttribute("reply", reply);
    		return "/board/postList.jsp";
    	}        
    }
}
