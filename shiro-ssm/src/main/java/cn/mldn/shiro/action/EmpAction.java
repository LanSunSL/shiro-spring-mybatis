package cn.mldn.shiro.action;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages/back/emp/*")
public class EmpAction {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("add")
	@RequiresAuthentication
	public ModelAndView add() {
		log.info("**************** 【EmpAction.add()】 ****************");
		return null;
	}
	@RequestMapping("edit")
	@RequiresRoles("dept")
	public ModelAndView edit() {
		log.info("**************** 【EmpAction.edit()】 ****************");
		return null;
	}
	@RequestMapping("delete")
	@RequiresPermissions("news:add")
	public ModelAndView delete() {
		log.info("**************** 【EmpAction.delete()】 ****************");
		return null;
	}
}
