package com.clickerSystem.app.service;

import com.clickerSystem.app.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickerSystem.app.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO studentDAO;
	
	public void addStudent(Student s){
		studentDAO.addStudent(s);
	}
	public void updateStudent(Student s, String name, String password){
		studentDAO.updateStudent(s, name, password);
	}
	public Student getStudent(int id){
		return (Student)studentDAO.getStudent(id);
	}
	public void deleteStudent(int id){
		studentDAO.deleteStudent(id);
	}
	public List<Student> getStudents(){
		return studentDAO.getStudents();
	}
}
