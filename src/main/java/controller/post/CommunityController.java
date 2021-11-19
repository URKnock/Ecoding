package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.ReplyManager;
import model.service.dto.PostDTO;
import model.service.dto.ReplyDTO;

public class CommunityController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostManager post = PostManager.getInstance();
		ReplyManager manager = ReplyManager.getInstance();
		ReplyDTO reply = (ReplyDTO) request.getAttribute("reply");
		
    	int postId = 0;
    	int replyId = 0;
    	if(request.getParameter("pid") != null)
    		postId = Integer.parseInt(request.getParameter("pid"));
    	if(request.getParameter("rid") != null)
    		replyId = Integer.parseInt(request.getParameter("rid"));
		
		if(request.getMethod().equals("GET")) {
	    	String postTitle = request.getParameter("title");
		   	try {
		    	PostDTO dto = null;
		    	List<ReplyDTO> list = null;
		    	if(postId == 0 && !postTitle.isEmpty()) {
		    		dto = post.getPostByTitle(postTitle);
		    		list = manager.getReplyListByPost(dto.getPostId());
		    	} else {
		    		dto = post.getPostById(postId);
		    		list = manager.getReplyListByPost(postId);
		    	}
		    	request.setAttribute("post", dto);	
		    	request.setAttribute("comment", list);	
		   	} catch (Exception e) {
		   		request.setAttribute("exception", e);
		   	}
		   	return "/board/postView.jsp";  
		} else if(request.getMethod().equals("POST")) {
		    try {		
		    	manager.insert(reply);
		    	return "redirect:/board/view";
		    } catch (Exception e) {
		   		request.setAttribute("replyFailed", true);
		   		request.setAttribute("exception", e);
		    	request.setAttribute("reply", reply);
		    }
		} else if(request.getMethod().equals("PUT")) {
	    	try {
	    		manager.update(reply);
	    		return "redirect:/board/view";
	    	} catch (Exception e) {
	    		request.setAttribute("replyFailed", true);
	    		request.setAttribute("exception", e);
	    		request.setAttribute("reply", reply);
	    	} 
		} else if(request.getMethod().equals("DELETE")) {
	    	try {
	    		manager.delete(replyId);
	    		return "redirect:/board/view?rid=" + replyId;
	    	} catch (Exception e) {
	    		request.setAttribute("replyFailed", true);
	    		request.setAttribute("exception", e);
	    		request.setAttribute("reply", reply);
	    	}  
		}
		
		return "/board/postList.jsp";
    }
}
