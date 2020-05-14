package org.fkit.springboot.logintest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsonController {

	@RequestMapping("/index2")
	public String findBook() {
		System.out.println("JsonController invoked ...");
		
		return "index2";
	}

	@RequestMapping("/getJson")
	public String findBooks() {
		System.out.println("JsonController invoked ...");
		
		return "getJson";
	}
}
