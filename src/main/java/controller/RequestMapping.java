package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.post.*;
import controller.project.*;
import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	//mappings.put("/", new ForwardController("home.jsp"));
    	
        //홈페이지 기본 화면
        mappings.put("/home/main", new ForwardController("/view/home.jsp")); //홈
        mappings.put("/home/list", new ForwardController("/view/projectList.jsp")); //둘러보기
        
        //사용자 관련(로그인, 회원가입, 로그아웃)
    	mappings.put("/user/loginform", new ForwardController("/user/loginForm.jsp")); //로그인 폼으로 이동
        mappings.put("/user/login", new LoginController()); //로그인 버튼을 클릭했을 때 연산 실행
        mappings.put("/user/logout", new LogoutController()); //로그아웃 버튼을 클릭했을 때
        mappings.put("/user/list", new ListUserController()); //유저 목록 출력 ==> 안 쓸 것 같다.
        mappings.put("/user/view", new ViewUserController()); //유저 정보 (내 정보 보기)
        mappings.put("/user/update", new UpdateUserController()); //유저 수정 컨트롤러
        mappings.put("/user/register", new RegisterUserController()); //회원가입 폼으로 이동
        mappings.put("/user/drop", new DeleteUserController()); //회원 탈퇴 기능
        
        // 프로젝트 관련
    	mappings.put("/project/view", new ForwardController("/project/registerStart.jsp"));   
        mappings.put("/project/register/form", new ProjectRegisterController());
        mappings.put("/project/register", new ForwardController("/project/registerProjectForm_step4.jsp"));
        mappings.put("/project/support/view", new ViewProjectController());
        mappings.put("/project/support", new ProjectSupportController());
        mappings.put("/project/support/confirm", new ProjectSupportController());
        mappings.put("/project/support/complete", new ProjectSupportCompleteController());
        
        // 커뮤니티 관련
        mappings.put("/board/list", new PostListController());
        mappings.put("/board/view", new CommunityController());
        mappings.put("/board/form", new ForwardController("/board/postForm.jsp"));
        mappings.put("/board/create", new CreatePostController());
        mappings.put("/board/update", new UpdatePostController());
        mappings.put("/board/delete", new DeletePostController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
