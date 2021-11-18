package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.project.*;
import controller.user.ListUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.RegisterUserController;
import controller.user.ViewUserController;

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
        
    	mappings.put("/user/loginform", new ForwardController("/user/loginForm.jsp")); //로그인 폼으로 이동
        mappings.put("/user/login", new LoginController()); //로그인 버튼을 클릭했을 때 연산 실행
        mappings.put("/user/logout", new LogoutController()); //로그아웃 버튼을 클릭했을 때
        mappings.put("/user/list", new ListUserController()); //유저 목록 출력 ==> 안 쓸 것 같다.
        mappings.put("/user/view", new ViewUserController()); //유저 정보 (내 정보 보기)
        mappings.put("/user/register", new RegisterUserController()); //회원가입 폼으로 이동
        
    	mappings.put("/project/view", new ForwardController("/project/registerStart.jsp"));   
    	mappings.put("/project/start", new ForwardController("/project/registerProjectForm_step1.jsp"));   
        mappings.put("/project/register/form", new ProjectRegisterController());
        mappings.put("/project/support/view", new ViewProjectController());
        mappings.put("/project/support", new ProjectSupportController());
        mappings.put("/project/support/confirm", new ProjectSupportController());
        mappings.put("/project/support/complete", new ProjectSupportCompleteController());
                
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
