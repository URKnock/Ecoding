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
    	String keyword = request.getParameter("searchKeyword");
    	String type = request.getParameter("searchType");
    	
    	PostManager manager = PostManager.getInstance();
		List<Post> postList = manager.findPostList(keyword, type);
		
		request.setAttribute("postList", postList);				
		return "/board/postList.jsp";        
    }
}
