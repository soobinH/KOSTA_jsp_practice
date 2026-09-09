package pac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

/**
 * Servlet implementation class jstlTest
 */
@WebServlet(name = "JstlTest", urlPatterns = { "/jstlTest" })
public class jstlTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jstlTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users=new ArrayList<>();
		users.add(new User("hong","홍길동","서울시 금천구 가산동1", "010-1111-1111"));
		users.add(new User("kong","김길동","서울시 금천구 가산동2", "010-1111-2222"));
		users.add(new User("gong","고길동","서울시 금천구 가산동3", "010-1111-3333"));
		users.add(new User("jong","장길동","서울시 금천구 가산동4", "010-1111-4444"));
		users.add(new User("pong","박길동","서울시 금천구 가산동5", "010-1111-5555"));
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("jstlCore3.jsp").forward(request, response);
	}

}
