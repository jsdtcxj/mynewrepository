package org.fkit.springboot.logintest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.Student;
import org.fkit.springboot.logintest.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;

	@RequestMapping("/insert")
	public String insertStudent(Student student) {
		return "insert count: " + studentService.insertStudent(student);
	}
	
	@RequestMapping("/select")
	public Student selectByUsername(String username) {
		return studentService.selectByUsername(username);
	}
	
	@RequestMapping("/findAll")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@RequestMapping("/delete")
	public void delete(int id) {
		studentService.delete(id);
	}
	
	@RequestMapping("/update")
	public void update(Student student) {
		studentService.update(student);
	}
}

