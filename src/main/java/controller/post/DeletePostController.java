package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.ReplyManager;
import model.service.dto.ReplyDTO;

public class DeletePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostManager post = PostManager.getInstance();
    	ReplyManager reply = ReplyManager.getInstance();
    	int postId = 0;
    	try {
    		if(request.getParameter("pid") != null)
    			postId = Integer.parseInt(request.getParameter("pid"));
    		else
    			throw new Exception("Post Id 값이 없습니다!");
    		List<ReplyDTO> list = reply.getReplyListByPost(postId);
    		for(ReplyDTO r : list) {
    			reply.delete(r.getReplyId());
    		}
    		post.delete(postId);
    		return "redirect:/board/list";
    	} catch (Exception e) {
    		request.setAttribute("exception", e);
    		return "/board/postList.jsp?";
    	}    
    }
}
