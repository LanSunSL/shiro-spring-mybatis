package cn.mldn.shiro.realm.crm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.mldn.util.encrypt.PasswordUtil;

public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		Object tokenCredentials = PasswordUtil.getPassword(super.toString(token.getCredentials()));
		Object accountCredentials = super.getCredentials(info);
		return super.equals(tokenCredentials, accountCredentials);
	}
}
