package org.fkit.springboot.logintest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("AppSecurityConfigurer invoked ...");
		http.authorizeRequests()
		.antMatchers("/login", "/css/**", "/js/**", "/img/*").permitAll()
		.antMatchers("/", "/home").hasRole("USER")
		.antMatchers("/admin/**").hasAnyRole("ADMIN", "DBA")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.successHandler(appAuthenticationSuccessHandler)
		.usernameParameter("loginName").passwordParameter("password")
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("AppSecurityConfigurer configureGlobal() ...");
		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("tom").password("1234").roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("4567").roles("ADMIN","DBA");
	}

}
