package org.fkit.springboot.logintest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ThymeleafController {

	@RequestMapping("/regexptest")
	public String regexptest(HttpServletRequest request, HttpSession session) {
		request.setAttribute("book", "crazy spring book");
		
		session.setAttribute("school", "crazy software");
		
		request.getServletContext().setAttribute("name", "Thymeleaf template");
		
		return "success1";
	}
	
	@RequestMapping("/iftest")
	public String iftest(WebRequest webRequest) {
		webRequest.setAttribute("username", "fkit", webRequest.SCOPE_REQUEST);
		webRequest.setAttribute("age", "21", webRequest.SCOPE_REQUEST);
		webRequest.setAttribute("role", "admin", webRequest.SCOPE_REQUEST);
		return "success2";
	}
	
	@RequestMapping("/eachtest")
	public String eachtest(WebRequest webRequest) {
		List list = new ArrayList();
		list.add(new Person("Jack", "abc", "Java"));
		list.add(new Person("Tom", "efg", "C++"));
		list.add(new Person("Jerry", "hij", "phython"));
		webRequest.setAttribute("persons", list, webRequest.SCOPE_REQUEST);
		
		return "success3";
	}
}
