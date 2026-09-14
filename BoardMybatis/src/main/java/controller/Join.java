package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class Join
 */
@WebServlet("/member/join")
@MultipartConfig(
		maxFileSize=1024*1024*10,//개별 파일 최대 크기(10mb)
		maxRequestSize=1024*1024*10*4*5, //전체 요청 최대 크기(50mb)
		fileSizeThreshold=1024*1024*1 // 1mb 초과 시 임시 디스크경로사용
)

public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member =new Member();
		
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setPostcode(request.getParameter("postcode"));
		member.setAddress(request.getParameter("address"));
		member.setDetail_address(request.getParameter("detailAddress"));
		
		
		Part profile = request.getPart("profile");
		
		String uploadPath =(String)request.getServletContext().getAttribute("profilePath");
		String realPath = request.getServletContext().getRealPath(uploadPath);
		
		MemberService service = new MemberServiceImpl();
		try {
			service.join(member, realPath, profile);
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/common/error.jsp").forward(request, response);
			
		}
		
		
	}

}
