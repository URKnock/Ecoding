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
    	mappings.put("/", new ForwardController("index.jsp"));
    	 mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
         mappings.put("/user/login", new LoginController());
         mappings.put("/user/logout", new LogoutController());
         mappings.put("/user/list", new ListUserController());
         mappings.put("/user/view", new ViewUserController());
         mappings.put("/user/register", new RegisterUserController());
    	
    	mappings.put("/project/view", new ForwardController("/project/registerStart.jsp"));   
    	mappings.put("/project/start", new ForwardController("/project/registerProjectForm_step1.jsp"));   
        mappings.put("/project/register/form", new ProjectRegisterController());
                
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
