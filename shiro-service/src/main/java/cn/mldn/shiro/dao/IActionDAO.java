package cn.mldn.shiro.dao;

import java.util.Set;

public interface IActionDAO {
	public Set<String> findAllIdByMember(String mid);
}
