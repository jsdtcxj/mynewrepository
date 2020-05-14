package org.fkit.springboot.logintest.service;

import java.util.List;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.Student;
import org.fkit.springboot.logintest.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Resource
	private StudentRepository studentRepository;
	
	public int insertStudent(Student student) {
		return studentRepository.insertStudent(student);
	}
	
	public Student selectByUsername(String username) {
		return studentRepository.selectByUsername(username);
	}
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public void delete(int id) {
		studentRepository.delete(id);
	}
	
	public void update(Student student) {
		studentRepository.update(student);
	}
}
