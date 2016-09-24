package com.spoc.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

@Controller
public class checkFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		String path = req.getRequestURI();
		System.out.println(path);
		
		/*if(path.equals("/"))
		{
			req.getRequestDispatcher("jsp/affair.do").forward(arg0, arg1);
		}
		else if(path.endsWith("*.do") &&!path.endsWith(".jsp")){
			*/
		if (!path.endsWith("affair.do") && !path.endsWith("login.do")
				&& !path.endsWith("changeAffair.do")
				&& !path.endsWith("lianxijsp.do")&& !path.endsWith("applyjsp.do") && !path.endsWith("apply.do")				
				&& !path.endsWith("lianxi.do") && !path.endsWith("upload.do") && !path.endsWith("success.jsp")) {

			System.out.println(req.getSession().getAttribute("user"));
			if (req.getSession().getAttribute("user") == null) {

				res.sendRedirect("/affair.do");
			}
		}
		/*}*/

		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
