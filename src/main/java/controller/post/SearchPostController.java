package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Post;
import model.service.PostManager;

public class SearchPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	PostManager manager; // = PostManager.getInstance();
		List<Post> postList = null; // = manager.findPostList();
		
		request.setAttribute("postList", postList);				
		return "/postList.jsp";        
    }
}
