package cn.mldn.shiro.realm.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class DefaultFormAuthenticationFilter extends FormAuthenticationFilter {
	private String randname = "rand";
	private String randparam = "code";

	public void setRandname(String randname) {
		this.randname = randname;
	}

	public void setRandparam(String randparam) {
		this.randparam = randparam;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String rand = (String) session.getAttribute(this.randname);
		String code = req.getParameter(this.randparam);
		if (rand == null || "".equals(rand) || code == null || "".equals(code)) {
			req.setAttribute("error", "验证码不允许为空");
			return true;
		} else {
			if (!rand.equalsIgnoreCase(code)) {
				req.setAttribute("error", "验证码输入错误！");
				return true;
			}
		}
		return super.onAccessDenied(request, response);
	}
}
