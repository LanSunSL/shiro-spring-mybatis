package cn.mldn.shiro.service;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

public interface IEmpService {
	@RequiresAuthentication
	public boolean add();
	@RequiresRoles("dept")
	public boolean edit();
	@RequiresPermissions("news:add")
	public boolean delete();
}
