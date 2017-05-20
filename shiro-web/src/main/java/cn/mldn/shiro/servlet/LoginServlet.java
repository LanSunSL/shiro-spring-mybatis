package cn.mldn.shiro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid = req.getParameter("mid");
		String password = req.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(mid, password);
		String path = "/login.jsp";
		try {
			SecurityUtils.getSubject().login(token);
			path = "/pages/welcome.jsp";
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
