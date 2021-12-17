package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.PostManager;

public class ReportCommunityController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostManager manager = PostManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("pid"));
		
		HttpSession httpSession = request.getSession(true);
		String ecoerId = (String) httpSession.getAttribute("ecoerId");
		
		try {
			//response.setContentType("text/html; charset=UTF-8");
			//PrintWriter out = response.getWriter();
			int reportCnt = manager.report(postId, ecoerId);
			System.out.println("그것: " + reportCnt);
			if(reportCnt >= 10) {
				//out.println("<script>alert('신고 횟수가 누적되어 해당 게시물은 삭제되었습니다.');</script>");
				//out.flush();
				return "redirect:/board/list";
			} else if(reportCnt == -1) {
				//out.println("<script>alert('이미 신고한 게시물입니다.');</script>");
				//out.flush();
			}
			return "redirect:/board/view?pid=" + postId;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/board/postList.jsp";
	}

}
