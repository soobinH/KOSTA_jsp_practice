package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.ArticleService;
import service.ArticleServiceImpl;

/**
 * Servlet implementation class DetailArticle
 */
@WebServlet("/article/detail")
public class DetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer num = Integer.parseInt(request.getParameter("num"));
		ArticleService service = new ArticleServiceImpl();
		
		
		try {
			
			request.setAttribute("article", service.detailArticle(num));
			Member user = (Member)request.getSession().getAttribute("user");
			if(user!=null) {
				request.setAttribute("heart", service.isHeart(num, user.getId()));
			}
			request.getRequestDispatcher("/article/boarddetail.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 상세 조회 오류");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
