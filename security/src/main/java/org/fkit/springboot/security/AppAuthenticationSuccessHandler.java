package org.fkit.springboot.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = this.determineTargetUrl(authentication);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication auth) {
		String url = "";
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority g : authorities) {
			roles.add(g.getAuthority());
		}
		
		if(roles.contains("ROLE_ADMIN")) {
			url = "/admin";
		} else if(roles.contains("ROLE_USER")) {
			url = "/home";
		} else {
			url = "/accessDenied";
		}
		
		System.out.println("Url = " + url);
		return url;
	}
}
