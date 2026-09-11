package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import dto.Member;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountInfo")
public class AccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/acc/accountInfoForm.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String id=request.getParameter("id");
		
		AccountService service = new AccountServiceImpl();
		
		try {
			Account acc = service.accountInfo(id);
			request.setAttribute("acc", acc);
			request.getRequestDispatcher("/acc/accountInfo.jsp").forward(request, response);
	
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		
	}

}
