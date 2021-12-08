package controller.post;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.PostManager;

public class LikeCommunityController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostManager manager = PostManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("pid"));
		
		HttpSession httpSession = request.getSession(true);
		String ecoerId = (String) httpSession.getAttribute("ecoerId");
		System.out.println(ecoerId);
		
		try {
			//response.setContentType("text/html; charset=UTF-8");
			//PrintWriter out = response.getWriter();
			if(manager.like(postId, ecoerId) == 0) {
				//out.println("<script>alert('이미 좋아요한 게시글입니다.');</script>");
				//out.flush();
			}
			return "redirect:/board/view?pid=" + postId;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/board/postList.jsp";
	}

}
