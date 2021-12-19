package controller.post;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.ReplyManager;
import model.service.dto.PostDTO;

public class PostListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		List<PostDTO> postList;
		Map<Integer, Integer> replyCnt;
    	PostManager manager = PostManager.getInstance();
    	ReplyManager reply = ReplyManager.getInstance();
    	String keyword = request.getParameter("keyword");
    	String type = request.getParameter("type");
    	int cid = 0;
    	
    	if(request.getParameter("cid") != null)	// Community ID;
    		cid = Integer.parseInt(request.getParameter("cid"));
    	
    	if(keyword != null && type != null) {
    		postList = manager.findPostList(keyword, type);
    	} else {
    		postList = manager.display(cid);
    	}
    	replyCnt = reply.getAllReplyCount();
    	postList = manager.combineReplyCnt(postList, replyCnt);
    	
		request.setAttribute("postList", postList);				
		return "/board/postList.jsp";        
    }
}
