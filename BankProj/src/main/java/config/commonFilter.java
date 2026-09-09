package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 모든 url 패턴(/*에 필터 적용
@WebFilter("/*")
public class commonFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		
		HttpSession session = req.getSession();
		session.getAttribute("userId");
		String userId = (String)session.getAttribute("userId");
		
		if(!uri.endsWith("/login")&& (userId)==null) {
			res.sendRedirect("login");
			return;
		}
		
		chain.doFilter(req, res);

	}

}
