package org.fkit.springboot.security;

import org.fkit.springboot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setHideUserNotFoundExceptions(false);
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login","/css/**","/js/**","/img/*").permitAll()
		.antMatchers("/", "/home").hasRole("USER")
		.antMatchers("/admin/**").hasAnyRole("ADMIN","DBA")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").successHandler(appAuthenticationSuccessHandler)
		.usernameParameter("loginName").passwordParameter("password")
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	
}
