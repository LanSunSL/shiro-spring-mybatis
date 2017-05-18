package cn.mldn.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {
	@RequestMapping("/login")
	public ModelAndView login(String mid, String password) {
		ModelAndView mav = new ModelAndView("/login.jsp");
		UsernamePasswordToken token = new UsernamePasswordToken(mid,password);
		try {
		SecurityUtils.getSubject().login(token);
		mav.setViewName("/pages/welcome.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;
	}
}
