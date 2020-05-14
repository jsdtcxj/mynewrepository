package org.fkit.springboot.logintest.service;

import java.util.ArrayList;
import java.util.List;

import org.fkit.springboot.logintest.repository.MyUserRepository;
import org.fkit.springboot.logintest.security.pojo.FKRole;
import org.fkit.springboot.logintest.security.pojo.FKUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService{

	MyUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FKUser fkUser = userRepository.findByLoginName(username);
		if(fkUser == null) {
			throw new UsernameNotFoundException("user name is not found!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<FKRole> roles = fkUser.getRoles();
		
		for(FKRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return new User(fkUser.getUsername(), fkUser.getPassword(), authorities);
	}
	
	
}
