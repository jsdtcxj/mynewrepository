package org.fkit.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.fkit.springboot.security.pojo.FKRole;
import org.fkit.springboot.security.pojo.FKUser;
import org.fkit.springboot.security.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService{
	
	UserRepository userRepository;

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
