package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class PostViewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int id = Integer.parseInt(request.getParameter("post_id"));
    	String title = request.getParameter("title");
    	
    	PostManager manager = PostManager.getInstance();
    	PostDTO post = manager.getPostById(id);

    	if(post == null && !title.isEmpty()) {
    		post = manager.getPostByTitle(title);
    	}
    	
		request.setAttribute("post", post);				
		return "/board/postView.jsp";        
    }
}
