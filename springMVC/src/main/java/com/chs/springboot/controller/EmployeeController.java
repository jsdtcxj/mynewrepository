package com.chs.springboot.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chs.springboot.model.Employee;
import com.chs.springboot.model.EmployeeJsonResponse;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//http://localhost:8080/springMVC/employee/?hello=Hello&firstName=Chris&lastName=Cai
	@RequestMapping("/")
	public ModelAndView index(String hello, Employee employee) {
		if(employee != null) {
			System.out.println(hello + ", " + employee.getFirstName() + " " + employee.getLastName());
		}
		ModelAndView modelAndView = new ModelAndView("employeeForm");
		return modelAndView;
	}

	@PostMapping(value="/saveEmployee", produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public EmployeeJsonResponse saveEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
		EmployeeJsonResponse response = new EmployeeJsonResponse();
		if(result.hasErrors()) {
			Map<String,String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
					);
			response.setValidated(false);
			response.setErrorMessages(errors);
		} else {
			System.out.println(employee);
			response.setValidated(true);
			response.setEmployee(employee);
		}
		
		return response;
	}
}
