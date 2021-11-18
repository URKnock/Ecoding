package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class CreatePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostDTO post = (PostDTO) request.getAttribute("post");
    	//for(int i = 0; i < PostDTO.cols; i++) {
    	//	post.setWithIndex(i, request.getParameter(PostDTO.columns[i]));
    	//}
    	
    	try {
    		PostManager manager = PostManager.getInstance();
    		manager.insert(post);
    		return "redirect:/board/view";
    	} catch (Exception e) {
    		request.setAttribute("postFailed", true);
    		request.setAttribute("exception", e);
    		request.setAttribute("post", post);
    		return "/board/postForm.jsp";
    	}      
    }
}
