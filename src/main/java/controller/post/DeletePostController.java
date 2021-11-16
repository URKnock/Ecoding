package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class DeletePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostDTO post = (PostDTO) request.getAttribute("post");
    	try {
    		PostManager manager = PostManager.getInstance();
    		manager.delete(post.getPostId());
    		return "redirect:/board/view";
    	} catch (Exception e) {
    		request.setAttribute("exception", e);
    		return "/board/postList.jsp";
    	}    
    }
}
