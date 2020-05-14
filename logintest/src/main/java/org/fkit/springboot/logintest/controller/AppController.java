package org.fkit.springboot.logintest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		
		return "admin";
	}
	
	@RequestMapping("/dba")
	public String dbaPage(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		
		return "dba";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDeniedPage(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
				
		return "accessDenied";
	}
	
	@RequestMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	private String getUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("username = " + username);
		return username;
	}
	
	private String getAuthority() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority a : auth.getAuthorities()) {
			roles.add(a.getAuthority());
		}
		
		System.out.println("Roles = " + roles.toString());
		return roles.toString();
	}
}
