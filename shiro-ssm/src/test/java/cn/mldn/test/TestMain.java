package cn.mldn.test;

import cn.mldn.util.encrypt.PasswordUtil;

public class TestMain {

	public static void main(String[] args) {
		System.out.println(PasswordUtil.getPassword("hello"));

		System.out.println(PasswordUtil.getPassword("java"));
	}

}
