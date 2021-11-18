package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class PostListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		List<PostDTO> postList;
    	PostManager manager = PostManager.getInstance();
    	String keyword = request.getParameter("searchKeyword");
    	String type = request.getParameter("searchType");
    	int cid = 0;
    	
    	if(request.getParameter("cid") != null)	//Community ID;
    		cid = Integer.parseInt(request.getParameter("cid"));
		
    	if(keyword != null && type != null) {
    		postList = manager.findPostList(keyword, type);
    		
    	} else {
    		postList = manager.display(cid);
    	}
		request.setAttribute("postList", postList);				
		return "/board/postList.jsp";        
    }
}
