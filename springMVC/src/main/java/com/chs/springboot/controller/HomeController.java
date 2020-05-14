package com.chs.springboot.controller;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chs.springboot.model.HelloWorld;
import com.chs.springboot.model.SignUpForm;
import com.chs.springboot.model.User;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
	
	@RequestMapping("/helloWorld")
	public String handler(Model model) {
		System.out.println("Hello World!!!");
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("This is a Message !!");
		helloWorld.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("helloWorld", helloWorld);
		return "helloWorld";
	}
	
	@ModelAttribute("signUpForm")
	public SignUpForm setSignUpForm() {
		SignUpForm signUpForm = new SignUpForm();
		signUpForm.setUserName("chris");
		return signUpForm;
	}
	
	@GetMapping("/showSignUpForm")
	public String shoForm() {
		return "signup-form";
	}
	
	@PostMapping("/saveSignUpForm")
	public String saveUser(@ModelAttribute("signUpForm") SignUpForm signUpForm, Model model) {
		System.out.println("FirstName : " + signUpForm.getFirstName());
        System.out.println("LastName : " + signUpForm.getLastName());
        System.out.println("Username : " + signUpForm.getUserName());
        System.out.println("Password : " + signUpForm.getPassword());
        System.out.println("Email : " + signUpForm.getEmail());
        
        model.addAttribute("message", "User sign up successfully");
        model.addAttribute("user", signUpForm);
        return "signup-success";
	}
}
