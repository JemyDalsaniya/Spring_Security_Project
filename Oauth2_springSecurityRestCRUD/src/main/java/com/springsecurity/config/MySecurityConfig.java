package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springsecurity.service.OauthUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration

public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	@Bean
//	public UserDetailsService userDetailsService() {
//		var user = new InMemoryUserDetailsManager();
//		user.createUser(
//				User.withUsername("jemy").password(passwordEncoder().encode("1234")).authorities("read").build());
//		return user;
//	}

	@Autowired
	private OauthUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("inside configure");

		http.

				csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();

	}

//
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService);// .passwordEncoder(passwordEncoder());
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
