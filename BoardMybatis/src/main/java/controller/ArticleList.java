package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ArticleService;
import service.ArticleServiceImpl;
import util.PageInfo;

/**
 * Servlet implementation class ArticleList
 */
@WebServlet("/article/list")
public class ArticleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPage = request.getParameter("page");
		Integer page = 1;
		if(sPage!=null && !sPage.isEmpty()) {
			page = Integer.parseInt(sPage);
		}
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		PageInfo pageInfo = new PageInfo(page);
		ArticleService service = new ArticleServiceImpl();
		try {
			List<Map<String,Object>> articleList =  service.articleList(pageInfo, keyword,type);
			request.setAttribute("articleList", articleList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/article/boardlist.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 목록 조회 오류");
			request.getRequestDispatcher("/common/error.jsp").forward(request, response);
		}
	}
}
