package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

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
		request.getRequestDispatcher("/acc/transfer.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendID = request.getParameter("sendID");
		String receiveID = request.getParameter("receiveID");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		AccountService service = new AccountServiceImpl();
		try {
			Account acc = service.transfer(sendID, receiveID, money);
			request.setAttribute("acc", acc);
			request.getRequestDispatcher("/acc/accountInfo.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
