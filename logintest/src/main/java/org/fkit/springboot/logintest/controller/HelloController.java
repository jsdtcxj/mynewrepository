package org.fkit.springboot.logintest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		
		System.out.println("Restarted server test3 ...");
		return "spring hot deployment3";
	}
}
