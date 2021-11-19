package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReplyManager;
import model.service.PostManager;
import model.service.dto.ReplyDTO;
import model.service.dto.PostDTO;

public class PostViewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {    	
    	int postId = 0;    	
    	if(request.getParameter("pid") != null)
    		postId = Integer.parseInt(request.getParameter("pid"));

    	try {
	    	PostManager manager = PostManager.getInstance();
	    	ReplyManager reply = ReplyManager.getInstance();
	    	
	    	PostDTO post = null;
	    	List<ReplyDTO> list = null;

	    	post = manager.getPostById(postId);
	    	list = reply.getReplyListByPost(postId);
	
	    	request.setAttribute("post", post);	
	    	request.setAttribute("comment", list);
	    	
    	} catch (Exception e) {
    		request.setAttribute("exception", e);
    	}
    	
    	return "/board/postView.jsp";	   
    }
}
