package cn.mldn.shiro.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.shiro.vo.Member;

public interface IMemberService {
	public Member get(String mid);
	public Map<String,Set<String>> getRoleAndAction(String mid);
}
