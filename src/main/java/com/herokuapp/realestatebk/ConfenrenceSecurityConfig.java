package com.herokuapp.realestatebk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.realestatebk.auth.UserDetailsConfig;
import com.herokuapp.realestatebk.form.FormNhanvien;
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
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin(CorsConfiguration.ALL);
		configuration.addAllowedMethod(CorsConfiguration.ALL);
		configuration.addAllowedHeader(CorsConfiguration.ALL);
		configuration.addAllowedOriginPattern(CorsConfiguration.ALL);
		configuration.addExposedHeader(CorsConfiguration.ALL);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
//	@Bean
//	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http
//			.cors(cors -> cors.disable());
//		return http.build();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(URL.HOME).permitAll()
			.antMatchers(URL.GET_ALL_Batdongsan).hasAnyAuthority(Role.ROLE_SALE ,Role.ROLE_ADMIN)
			.antMatchers(URL.GET_ALL_Nhanvien).hasAnyAuthority(Role.ROLE_ADMIN)
			.antMatchers(URL.GET_ALL_Khachhang).hasAnyAuthority(Role.ROLE_SALE ,Role.ROLE_ADMIN)
			.anyRequest().authenticated()	
			.and().httpBasic()
			.and().formLogin().usernameParameter("taikhoan").passwordParameter("matkhau")
			.successHandler(new AuthenticationSuccessHandler() {
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					FormNhanvien formNhanvien = ((UserDetailsConfig)authentication.getPrincipal()).getFormNhanvien();
					ObjectMapper mapper = new ObjectMapper();
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(mapper.writeValueAsString(formNhanvien));
				}
			})
			.failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().print(false);
				}
			})
			.and().csrf().disable()
			.logout()
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.and()
			.cors().configurationSource(corsConfigurationSource());
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
