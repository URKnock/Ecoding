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
import model.service.UserManager;

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
		
		if(check) {
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/resources/img");
			File dir = new File(path);
			
			if(!dir.exists()) dir.mkdir();
			
			try {
				HttpSession session = request.getSession();
				String ecoerId = UserSessionUtils.getLoginEcoerId(session);	
	    		Project project =  (Project)session.getAttribute("project");
	    		project.setEcoerId(ecoerId);
	    		
				DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(1024 * 1024 * 10);
                factory.setRepository(dir);            
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(10 * 1024 * 1024);
                upload.setHeaderEncoding("utf-8");
                                
                List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
                
                for(int i = 0; i < items.size(); ++i) {
                	FileItem item = (FileItem)items.get(i);
                	
                	String value = item.getString("utf-8");
                	
                	if(item.isFormField()) {             		
                		if(item.getFieldName().equals("detailInfo")) {
                			detailInfo = value;
                			project.setDetailInfo(detailInfo);
                		}
                		else if(item.getFieldName().equals("planInfo")) {
                			planInfo = value;
            				project.setPlanInfo(planInfo);
                		}
                		else if(item.getFieldName().equals("exchangeInfo")) {
                			exchangeInfo = value;
            				project.setExchangeInfo(exchangeInfo);
                		}
                	}
                	else {
                		if(item.getFieldName().equals("thumbnailVideo")) {
                			thumbnailVideo = item.getName();
                			if(thumbnailVideo == null || thumbnailVideo.trim().length() == 0) continue;
                			thumbnailVideo = thumbnailVideo.substring(thumbnailVideo.lastIndexOf("\\") + 1);
                			File file = new File(dir, thumbnailVideo);
                			item.write(file);
                			project.setProjectVideo(thumbnailVideo);
                		}
                		if(item.getFieldName().equals("thumbnailImage")) {
                			thumbnailImage = item.getName();
                			if(thumbnailImage == null || thumbnailImage.trim().length() == 0) continue;
                			thumbnailImage = thumbnailImage.substring(thumbnailImage.lastIndexOf("\\") + 1);
                			File file = new File(dir, thumbnailImage);
                			item.write(file);
                			project.setImage(thumbnailImage);
                		}
                		if(item.getFieldName().equals("projectFile")) {
                			projectFile = item.getName();
                			if(projectFile == null || projectFile.trim().length() == 0) continue;
                			projectFile = projectFile.substring(projectFile.lastIndexOf("\\") + 1);
                			File file = new File(dir, projectFile);
                			item.write(file);
                			project.setProjectFile(projectFile);
                		}
                	}
                }
                
                UserManager manager = UserManager.getInstance();
        		boolean ck = manager.findEcoer(ecoerId).getIsCreator();

        		session.setAttribute("project", project);
        		
        		request.setAttribute("isCre", ck);
    			
			}catch(SizeLimitExceededException e) {
				e.printStackTrace();          
				return "/project/registerProjectForm_step2.jsp";
            }catch(FileUploadException e) {
                e.printStackTrace();
                return "/project/registerProjectForm_step2.jsp";
            }catch(Exception e) {            
                e.printStackTrace();
                return "/project/registerProjectForm_step2.jsp";
            }
		}
		return "/project/registerProjectForm_step3.jsp";
    }
}