package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.Article;
import service.ArticleService;
import service.ArticleServiceImpl;

/**
 * Servlet implementation class WriteArticle
 */
@WebServlet("/article/write")
@MultipartConfig(
	maxFileSize = 1024*1024*10, //개별 파일 최대 크기(10MB)
	maxRequestSize = 1024*1024*10*5, //전체 요청 최대 크리(50MB)
	fileSizeThreshold = 1024*1024*1 //1MB 초과시 임시 디스크 경로 사용
)
public class WriteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/article/writeform.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		Article article = new Article(title,content,writer);
		
		Part ifile =  request.getPart("ifile");
		Part dfile = request.getPart("dfile");
		
		String uploadPath = (String)request.getServletContext().getAttribute("uploadPath");
		String realPath = request.getServletContext().getRealPath(uploadPath);	
		
		ArticleService service = new ArticleServiceImpl();
		
		try {
			Integer num = service.writeArticle(article, realPath, ifile, dfile);
			request.setAttribute("article", service.detailArticle(num));
			request.getRequestDispatcher("/article/boarddetail.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/common/error.jsp").forward(request, response);
		}
	}
}
