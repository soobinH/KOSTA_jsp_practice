package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("transfer.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String rid = request.getParameter("rid");
		Integer money = Integer.parseInt(request.getParameter("money"));
		HttpSession session = request.getSession();
		Account sacc = (Account)session.getAttribute(sid);
		Account racc = (Account)session.getAttribute(rid);
		
		
		if(sacc==null) {
			request.setAttribute("err","보내는 계좌번호가 틀립니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else if(racc==null) {
			request.setAttribute("err","보내는 계좌번호가 틀립니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			sacc.withdraw(money);
			racc.deposit(money);
			request.setAttribute("acc", sacc);
			request.getRequestDispatcher("accountInfo.jsp").forward(request, response);
		}
	}

}
