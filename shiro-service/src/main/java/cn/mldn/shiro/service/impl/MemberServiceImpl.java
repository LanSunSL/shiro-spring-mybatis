package cn.mldn.shiro.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.shiro.dao.IActionDAO;
import cn.mldn.shiro.dao.IMemberDAO;
import cn.mldn.shiro.dao.IRoleDAO;
import cn.mldn.shiro.service.IMemberService;
import cn.mldn.shiro.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDAO memberDAO ;
	@Resource
	private IRoleDAO roleDAO;
	@Resource
	private IActionDAO actionDAO;
	
	@Override
	public Member get(String mid) {
		return this.memberDAO.findByMid(mid);
	}

	@Override
	public Map<String, Set<String>> getRoleAndAction(String mid) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put("allRoles", this.roleDAO.findAllIdByMember(mid));
		map.put("allActions", this.actionDAO.findAllIdByMember(mid));
		return map;
	}

}
