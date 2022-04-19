package com.herokuapp.realestatebk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.herokuapp.realestatebk.util.Role;
import com.herokuapp.realestatebk.util.URL;

@EnableWebSecurity
public class ConfenrenceSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, URL.LOGIN_Nhanvien).permitAll()
			.antMatchers(HttpMethod.GET, URL.GET_ALL_Batdongsan).hasAnyAuthority(Role.ROLE_SALE ,Role.ROLE_ADMIN)
			.antMatchers(HttpMethod.GET, URL.GET_ALL_Nhanvien).hasAnyAuthority(Role.ROLE_ADMIN)
			.antMatchers(HttpMethod.POST, URL.ADD_Nhanvien).hasAnyAuthority(Role.ROLE_ADMIN)
			.and().httpBasic()
			.and().formLogin().usernameParameter("taikhoan").passwordParameter("matkhau")
			.defaultSuccessUrl(URL.SUCCESS)
			.failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.getWriter().write("false");
				}
			})
			.and().csrf().disable()
			.logout()
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
