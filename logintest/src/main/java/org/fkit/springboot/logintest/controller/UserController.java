package org.fkit.springboot.logintest.controller;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.User;
import org.fkit.springboot.logintest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/save")
	public String save() {
		User user = new User();
		user.setAge(20);
		user.setLoginName("Tom");
		user.setSex("Male");
		user.setUsername("Thomas");
		
		userService.save(user);
		return "success";
	}
	
	@RequestMapping("/find")
	public String findById() {
		return userService.findUsernameById(1);
	}
}
