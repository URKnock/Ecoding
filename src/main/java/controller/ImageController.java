package controller;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ImageController implements Controller {
    private String path;

    public ImageController(String path) {
        if (path == null) {
            throw new NullPointerException("Path is null. �̵��� URL�� �Է��ϼ���.");
        }
        this.path = path;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = servletContext.getResourcesAsStream(path);
        resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(is,  resp.getOutputStream());
        
    }
}
