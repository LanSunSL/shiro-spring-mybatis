package cn.mldn.shiro.service;

import java.util.Set;

import cn.mldn.shiro.vo.Member;

public interface IMemberService {
	public Member get(String id) throws Exception;
	public Set<String> listRolesByMember(String id) throws Exception;
	public Set<String> listActionsByMember(String id) throws Exception;
}
