package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.PostManager;
import model.service.ReplyManager;
import model.service.dto.PostDTO;
import model.service.dto.ReplyDTO;

public class CommunityController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostManager post = PostManager.getInstance();
		ReplyManager manager = ReplyManager.getInstance();
		ReplyDTO reply = (ReplyDTO) request.getAttribute("reply");
		
    	int postId = 0;
    	if(request.getParameter("pid") != null)
    		postId = Integer.parseInt(request.getParameter("pid"));
		
		if(request.getMethod().equals("GET")) {
	    	String postTitle = request.getParameter("title");
	    	
		   	try {
		   		post.view(postId);
		    	PostDTO dto = null;
		    	List<ReplyDTO> list = null;
		    	
		    	if(postId == 0 && !postTitle.isEmpty()) {
		    		dto = post.getPostByTitle(postTitle);
		    		list = manager.getReplyListByPost(dto.getPostId());
		    	} else {
		    		dto = post.getPostById(postId);
		    		list = manager.getReplyListByPost(postId);
		    	}
		    	
		    	String projectInfo = dto.getProjectInfo();
		    	if(projectInfo != null) {
		    		String[] project = projectInfo.split(":");
		    		System.out.println(project);
		    		request.setAttribute("project_id", project[0]);
		    		request.setAttribute("project_title", project[1]);
		    	}
		    	
		    	request.setAttribute("post", dto);	
		    	request.setAttribute("comment", list);	
		   	} catch (Exception e) {
		   		request.setAttribute("exception", e);
		   	}
		   	return "/board/postView.jsp";  
		} else if(request.getMethod().equals("POST")) {
			String method = request.getParameter("_method").toUpperCase();
			System.out.println(method);
		    if(method.equals("PUT")) {
		    	try {
		    		manager.update(reply);
		    		return "redirect:/board/view?pid=" + postId;
		    	} catch (Exception e) {
		    		request.setAttribute("replyFailed", true);
		    		request.setAttribute("exception", e);
		    		request.setAttribute("reply", reply);
		    	} 
		    } else if(method.equals("DELETE")) {
		    	try {
		        	int replyId = 0;
		        	if(request.getParameter("rid") != null)
		        		replyId = Integer.parseInt(request.getParameter("rid"));
		    		manager.delete(replyId);
		    		return "redirect:/board/view?pid=" + postId;
		    	} catch (Exception e) {
		    		request.setAttribute("replyFailed", true);
		    		request.setAttribute("exception", e);
		    		request.setAttribute("reply", reply);
		    	} 
		    } else {
			    try {
			    	reply = new ReplyDTO();
			    	reply.setPostId(postId);
			    	reply.setReplyContent(request.getParameter("reply_content"));
			    	
        			HttpSession session = request.getSession();
        			String ecoerId = UserSessionUtils.getLoginEcoerId(session);
        			if(ecoerId == null)
        				reply.setEcoerId("test");
        			else
						reply.setEcoerId(ecoerId);
						
			    	manager.insert(reply);
			    	return "redirect:/board/view?pid=" + postId;
			    } catch (Exception e) {
			   		request.setAttribute("replyFailed", true);
			   		request.setAttribute("exception", e);
			    	request.setAttribute("reply", reply);
			    }
		    }
		}
		return "/board/postList.jsp";
    }
}
