package com.clickerSystem.app.service;

import com.clickerSystem.app.model.Student;
import java.util.List;


public interface StudentService {
	
	public void addStudent(Student s);
	public void updateStudent(Student s, String name, String password);
	public Student getStudent(int id);
	public void deleteStudent(int id);
	public List<Student> getStudents();
}
