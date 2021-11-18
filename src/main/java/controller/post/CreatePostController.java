package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class CreatePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	System.out.println("들어왓음");
    	PostDTO post = new PostDTO();
    	PostManager manager = PostManager.getInstance();
    	try {
        	for(int i = 0; i < PostDTO.cols; i++) {
        		String req = request.getParameter(PostDTO.columns[i]);
        		System.out.println(PostDTO.columns[i] + " : " + req);
        		if(i == 0)
        			post.setWithIndex(i, 0);
        		else if(i == 8)
        			post.setWithIndex(i, "test");	//session.user로 바꿀 것
        		else if(i == 9)
        			post.setWithIndex(i, Integer.parseInt(req));
        		else
        			post.setWithIndex(i, req);
        		
        	}
    		int pid = manager.insert(post);   		
    		return "redirect:/board/view?pid=" + pid;
    	} catch (Exception e) {
    		request.setAttribute("postFailed", true);
    		request.setAttribute("exception", e);
    		request.setAttribute("post", post);
    		e.printStackTrace();
    		return "/board/postForm.jsp";
    	}      
    }
}
