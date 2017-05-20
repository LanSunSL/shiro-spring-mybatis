package cn.mldn.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String pasword = new String((char[]) token.getCredentials());
		if (!"hello".equals(username)) {
			throw new UnknownAccountException("No such user!");
		}
		if (!"world".equals(pasword)) {
			throw new IncorrectCredentialsException("Wrong password!");
		}
		return new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),this.getName());
	}

	@Override
	public String getName() {
		return "my-shiro-realm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

}
