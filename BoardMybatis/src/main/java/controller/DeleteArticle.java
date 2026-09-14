package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ArticleService;
import service.ArticleServiceImpl;

/**
 * Servlet implementation class DeleteArticle
 */
@WebServlet("/article/delete")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer num = Integer.parseInt(request.getParameter("num"));
		Integer page = Integer.parseInt(request.getParameter("num"));
		
		ArticleService service = new ArticleServiceImpl();
		try {
			service.deleteArticle(num);
			response.sendRedirect(request.getContextPath()+"/article/list?page="+page);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 삭제 오류입니다.");
			request.getRequestDispatcher("/common/error.jsp").forward(request, response);
		}
	}

}
