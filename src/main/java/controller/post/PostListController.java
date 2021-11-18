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
    	PostManager manager = PostManager.getInstance();
		List<PostDTO> postList = manager.getPostList();

		request.setAttribute("postList", postList);				
		return "/board/postList.jsp";        
    }
}
