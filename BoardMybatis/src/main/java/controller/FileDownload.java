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

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDown")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		String uploadPath = request.getServletContext().getRealPath("/uploads");
		FileInputStream fis = null;
		try {
			String mimeType = request.getServletContext().getMimeType(uploadPath+"\\"+filename); 
			if(mimeType==null) {
				mimeType = "application/octet-stream"; // octet-stream : 8byte로 된 일련의 데이터를 뜻함. 지정하지 않은 타입을 의미
			}
			response.setContentType(mimeType);
			String encodingFilename =new String(filename.getBytes("utf-8"), "8859_1");
			response.setHeader("content-Disposition", "attatchment; filename="+encodingFilename);
			
			fis = new FileInputStream(new File(uploadPath,filename));
			OutputStream out = response.getOutputStream();
			
			byte[] buff=new byte[4096];
			int len;
			while((len=fis.read(buff))>0) {
				out.write(buff, 0, len);
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write("파일 다운로드를 실패했습니다.");
		}finally {
			try {
				if(fis!=null) fis.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
