package com.herokuapp.realestatebk.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public class TestEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		return (String) rawPassword;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
