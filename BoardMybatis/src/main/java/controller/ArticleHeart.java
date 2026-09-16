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
 * Servlet implementation class ArticleHeart
 */
@WebServlet("/article/heart")
public class ArticleHeart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleHeart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer articleNum = Integer.parseInt(request.getParameter("num"));
		try {
			Member member = (Member)request.getSession().getAttribute("user");
			if(member == null) throw new Exception("로그인이 필요합니다.");
			ArticleService service = new ArticleServiceImpl();
			Boolean isHeart = service.toggleHeart(articleNum, member.getId());
			response.getWriter().write(String.valueOf(isHeart));
			
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
	}

}
