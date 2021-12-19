package controller.my;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.PostManager;
import model.service.dto.PostDTO;

public class UserPostListViewController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String ecoerId = UserSessionUtils.getLoginEcoerId(session);
		
		PostManager manager = PostManager.getInstance();
		List<PostDTO> postList = manager.findPostList(ecoerId, "ecoer_id");
		request.setAttribute("postList", postList);
		
		return "/user/myPostView.jsp";

	}
}

