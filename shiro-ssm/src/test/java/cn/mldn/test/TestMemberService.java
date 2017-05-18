package cn.mldn.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.shiro.service.IMemberService;
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMemberService {
	@Resource
	private IMemberService memberService;
	@Test
	public void testGet() {
		System.out.println(this.memberService.get("mldn"));
	}
	@Test
	public void testGetRoleAndAction() {
		System.out.println(this.memberService.getRoleAndAction("mldn"));
	}
}
