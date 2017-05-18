package cn.mldn.shiro.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageAction {
	@RequestMapping("/loginPage")
	public ModelAndView login(String mid, String password) {
		ModelAndView mav = new ModelAndView("/login.jsp");
		return mav;
	}
}
