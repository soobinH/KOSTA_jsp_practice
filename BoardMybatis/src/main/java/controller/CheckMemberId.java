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
 * Servlet implementation class CheckMemberId
 */
@WebServlet("/member/doubleId")
public class CheckMemberId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMemberId() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberService service = new MemberServiceImpl();
		try {
			boolean isExixt = service.checkMemberId(id);
			response.getWriter().write(String.valueOf(isExixt));
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write("아이디 중복 체크 오류");
		}
	}

}
