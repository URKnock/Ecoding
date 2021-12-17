package controller.project;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Project;
import model.service.CreatorManager;
import model.service.UserManager;
import model.service.dto.CreatorDTO;

//파일 업로드를 위한 API를 사용하기 위해...
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;

//파일 용량 초과에 대한 Exception 클래스를 FileUploadBase 클래스의 Inner 클래스로 처리
import org.apache.commons.fileupload.servlet.*;

public class ProjectFileRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String thumbnailVideo = null;
    	String thumbnailImage = null;
    	String detailInfo = null;
    	String planInfo = null;    
    	String exchangeInfo = null;    
    	String projectFile = null;    
    	
    	boolean check = ServletFileUpload.isMultipartContent(request);
		//전송된 데이터의 인코드 타입이 multipart 인지 여부를 체크한다.
		//만약 multipart가 아니라면 파일 전송을 처리하지 않는다.
		
		if(check) {//파일 전송이 포함된 상태가 맞다면
			
			// 아래와 같이 하면 Tomcat 내부에 복사된 프로젝트의 폴더 밑에 upload 폴더가 생성됨 
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/resources/img");
			File dir = new File(path);
			
			// Tomcat 외부의 폴더에 저장하려면 아래와 같이 절대 경로로 폴더 이름을 지정함
			// File dir = new File("C:/Temp");
			
			if(!dir.exists()) dir.mkdir();
			//전송된 파일을 저장할 실제 경로를 만든다.
			
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(10 * 1024);
                factory.setRepository(dir);            
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(10 * 1024 * 1024);
                upload.setHeaderEncoding("utf-8");
                                
                List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
                
                for(int i = 0; i < items.size(); ++i) {
                	FileItem item = (FileItem)items.get(i);
                	
                	String value = item.getString("utf-8");
                	
                	if(item.isFormField()) {             		
                		if(item.getFieldName().equals("detailInfo")) detailInfo = value;
                		else if(item.getFieldName().equals("planInfo")) planInfo = value;
                		else if(item.getFieldName().equals("exchangeInfo")) exchangeInfo = value;
                	}
                	else {//파일이라면...
                		if(item.getFieldName().equals("thumbnailVideo")) {
                			thumbnailVideo = item.getName();//파일 이름 획득 (자동 한글 처리 됨)
                			if(thumbnailVideo == null || thumbnailVideo.trim().length() == 0) continue;
                			//파일이 전송되어 오지 않았다면 건너 뛴다.
                			thumbnailVideo = thumbnailVideo.substring(thumbnailVideo.lastIndexOf("\\") + 1);
                			//파일 이름이 파일의 전체 경로까지 포함하기 때문에 이름 부분만 추출해야 한다.
                			//실제 C:\Web_Java\aaa.gif라고 하면 aaa.gif만 추출하기 위한 코드이다.
                			File file = new File(dir, thumbnailVideo);
                			item.write(file);
                			//파일을 upload 경로에 실제로 저장한다.
                			//FileItem 객체를 통해 바로 출력 저장할 수 있다.
                		}
                		if(item.getFieldName().equals("thumbnailImage")) {
                			thumbnailImage = item.getName();//파일 이름 획득 (자동 한글 처리 됨)
                			if(thumbnailImage == null || thumbnailImage.trim().length() == 0) continue;
                			//파일이 전송되어 오지 않았다면 건너 뛴다.
                			thumbnailImage = thumbnailImage.substring(thumbnailImage.lastIndexOf("\\") + 1);
                			//파일 이름이 파일의 전체 경로까지 포함하기 때문에 이름 부분만 추출해야 한다.
                			//실제 C:\Web_Java\aaa.gif라고 하면 aaa.gif만 추출하기 위한 코드이다.
                			File file = new File(dir, thumbnailImage);
                			item.write(file);
                			//파일을 upload 경로에 실제로 저장한다.
                			//FileItem 객체를 통해 바로 출력 저장할 수 있다.
                		}
                		if(item.getFieldName().equals("projectFile")) {
                			projectFile = item.getName();//파일 이름 획득 (자동 한글 처리 됨)
                			if(projectFile == null || projectFile.trim().length() == 0) continue;
                			//파일이 전송되어 오지 않았다면 건너 뛴다.
                			projectFile = projectFile.substring(projectFile.lastIndexOf("\\") + 1);
                			//파일 이름이 파일의 전체 경로까지 포함하기 때문에 이름 부분만 추출해야 한다.
                			//실제 C:\Web_Java\aaa.gif라고 하면 aaa.gif만 추출하기 위한 코드이다.
                			File file = new File(dir, projectFile);
                			item.write(file);
                			//파일을 upload 경로에 실제로 저장한다.
                			//FileItem 객체를 통해 바로 출력 저장할 수 있다.
                		}
                	}
                }
			}catch(SizeLimitExceededException e) {
			//업로드 되는 파일의 크기가 지정된 최대 크기를 초과할 때 발생하는 예외처리
				e.printStackTrace();          
				return "/project/registerProjectForm_step2.jsp";
            }catch(FileUploadException e) {
            //파일 업로드와 관련되어 발생할 수 있는 예외 처리
                e.printStackTrace();
                return "/project/registerProjectForm_step2.jsp";
            }catch(Exception e) {            
                e.printStackTrace();
                return "/project/registerProjectForm_step2.jsp";
            }
		}
		
		try {
			HttpSession session = request.getSession();
			String ecoerId = UserSessionUtils.getLoginEcoerId(session);	
    		Project project =  (Project)session.getAttribute("project");
    		
			project.setEcoerId(ecoerId);
			project.setDetailInfo(request.getParameter("detailInfo"));
			project.setPlanInfo(request.getParameter("planInfo"));
			project.setExchangeInfo(request.getParameter("exchangeInfo"));
			
    		UserManager manager = UserManager.getInstance();
    		boolean ck = manager.findEcoer(ecoerId).getIsCreator();

    		session.setAttribute("project", project);
    		
    		request.setAttribute("isCre", ck);
			return "/project/registerProjectForm_step3.jsp";
		} catch (Exception e) {
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			return "/project/registerProjectForm_step2.jsp";
		}
    }
}