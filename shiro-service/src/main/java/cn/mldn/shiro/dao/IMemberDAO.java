package cn.mldn.shiro.dao;

import cn.mldn.shiro.vo.Member;

public interface IMemberDAO {
	public Member findById(String mid);
}
