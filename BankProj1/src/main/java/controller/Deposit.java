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
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("deposit.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		if(acc == null) {
			request.setAttribute("err", "계좌번호가 틀립니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			acc.deposit(money);
			request.setAttribute("acc", acc);
			request.getRequestDispatcher("accountInfo.jsp").forward(request, response);
		}
	}

}
