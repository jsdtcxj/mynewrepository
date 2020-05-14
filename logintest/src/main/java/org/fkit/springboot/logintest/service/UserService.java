package org.fkit.springboot.logintest.service;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.User;
import org.fkit.springboot.logintest.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
	public String findUsernameById(int id) {
		return userRepository.findById(id).getUsername();
	}
}
