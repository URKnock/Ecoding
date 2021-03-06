package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;

public class DeletePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostManager post = PostManager.getInstance();
    	int postId = 0;
    	try {
    		if(request.getParameter("pid") != null)
    			postId = Integer.parseInt(request.getParameter("pid"));
    		else
    			throw new Exception("Post Id 값이 없습니다!");
    		post.delete(postId);
    		return "redirect:/board/list";
    	} catch (Exception e) {
    		request.setAttribute("exception", e);
    		return "/board/postList.jsp";
    	}    
    }
}
