package org.fkit.springboot.logintest.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return encodedPassword.equals(rawPassword.toString());
	}

}
