package cn.mldn.shiro.dao;

import java.util.Set;

public interface IRoleDAO {
	public Set<String> findAllIdByMember(String mid);
}
