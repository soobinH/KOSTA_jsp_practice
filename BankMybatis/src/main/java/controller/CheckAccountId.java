package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class CheckAccountId
 */
@WebServlet("/doubleAccId")
public class CheckAccountId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAccountId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jsonObject = JsonParser.parseReader(request.getReader()).getAsJsonObject();
		String accId=jsonObject.get("addId").getAsString();
		System.out.println(accId);
		AccountService service = new AccountServiceImpl();
		JsonObject resJson = new JsonObject();
		try {
			boolean isDouble = service.checkAccountId(accId);
			resJson.addProperty("status", "success");
			resJson.addProperty("exist", isDouble);
			String str="{\"status\":\"success\",\"exist\":true}";
		} catch(Exception e) {
			e.printStackTrace();
			resJson.addProperty("status", "fail");
		}
		response.getWriter().write(resJson.toString());
	}

}
