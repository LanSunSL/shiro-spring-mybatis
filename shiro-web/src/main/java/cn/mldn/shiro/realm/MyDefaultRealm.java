package cn.mldn.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.mldn.shiro.service.IMemberService;
import cn.mldn.shiro.service.impl.MemberServiceImpl;
import cn.mldn.shiro.vo.Member;

public class MyDefaultRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("==================2. 授权处理操作===================");
		String userid = principals.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		IMemberService memberService = new MemberServiceImpl();
		try {
			auth.setRoles(memberService.listRolesByMember(userid));
			auth.setStringPermissions(memberService.listActionsByMember(userid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auth;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("==================1. 认证处理操作===================");
		IMemberService memberService = new MemberServiceImpl();
		String userid = token.getPrincipal().toString();

		try {
			Member member = null;
			try {
				member = memberService.get(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (member == null) {
				throw new UnknownAccountException("No Such User!");
			}
			String password = new String((char[]) token.getCredentials());
			if (!password.equals(member.getPassword())) {
				throw new IncorrectCredentialsException("Wrong password!");
			}
			if (member.getLocked().equals(1)) {
				throw new LockedAccountException("Account is Locked!");
			}

		} catch (AuthenticationException e) {
			throw e;
		}
		SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(),
				"myshirorealm");
		return auth;
	}

}
