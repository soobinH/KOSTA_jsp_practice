package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommonService;
import service.CommonServiceImpl;

/**
 * Servlet implementation class ImageView
 */
@WebServlet(
		urlPatterns={"/image", "/profile"})
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String filename = request.getParameter("filename");
		if(filename == null || filename.trim().isEmpty()) {
	        return; 
	    }
		String servletPath = request.getServletPath();
		
		CommonService service = new CommonServiceImpl();
		try {
			String uploadPath;
			if(servletPath.equals("/image"))
				uploadPath = (String)request.getServletContext().getAttribute("uploadPath");
			else if(servletPath.equals("/profile"))
				uploadPath = (String)request.getServletContext().getAttribute("profilePath");
			else throw new Exception("이미지경로 오류");
			
			String realPath = request.getServletContext().getRealPath(uploadPath);
			service.imageView(realPath, filename, response.getOutputStream());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
