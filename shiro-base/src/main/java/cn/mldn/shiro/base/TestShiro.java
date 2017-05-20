package cn.mldn.shiro.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;


public class TestShiro {
	public static void main(String[] args) {
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "2E866BF58289E01583AD418F486A69DF");
		subject.login(token);
		System.out.println(subject.getPrincipal());
		System.out.println(subject.hasRole("dept"));
		System.out.println(subject.hasRole("news"));
		System.out.println(subject.isPermitted("news:list"));
		System.out.println(subject.isPermitted("member:add"));
		System.out.println(subject.isPermittedAll("news:list","news:add","news:edit"));
		System.out.println(subject.isPermittedAll("news:list","news:add","news:edit","member:add"));
	}
}
