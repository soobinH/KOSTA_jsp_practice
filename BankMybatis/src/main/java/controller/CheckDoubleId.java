package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class CheckDoubleId
 */
@WebServlet("/member/doubleId")
public class CheckDoubleId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDoubleId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		MemberService service = new MemberServiceImpl();
		try {
			boolean isExist = service.checkDoubleId(id);
			response.getWriter().write(String.valueOf(isExist));
		} catch(Exception e) {
			response.getWriter().write("아이딪 중복 체크 오류");
		}
		
	}

}
