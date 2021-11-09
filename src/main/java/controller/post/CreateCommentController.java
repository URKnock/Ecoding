package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comment;

public class CreateCommentController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	Comment comment = null;
    	
		request.setAttribute("comment", comment);				
		return "/postList.jsp";        
    }
}
