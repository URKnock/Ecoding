package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class CreatePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostDTO post = new PostDTO();
    	PostManager manager = PostManager.getInstance();
    	try {
        	for(int i = 0; i < PostDTO.cols; i++) {
        		String req = request.getParameter(PostDTO.columns[i]);
        		if(i == 0)
        			post.setWithIndex(i, 0);
        		else if(i == 8)
        		{
        			HttpSession session = request.getSession();
        			String ecoerId = UserSessionUtils.getLoginEcoerId(session);
        			if(ecoerId == null)
        				post.setWithIndex(i, "test");
        			else
						post.setEcoerId(ecoerId);
        		}
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
