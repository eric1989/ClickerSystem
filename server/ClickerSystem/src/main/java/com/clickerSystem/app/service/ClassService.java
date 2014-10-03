package com.clickerSystem.app.service;

import com.clickerSystem.app.model.Class;
import com.clickerSystem.app.model.Instructor;
import com.clickerSystem.app.model.Student;

import java.util.List;


public interface ClassService {
	
	public void addClass(Class c);
	public void updateClass(Class c, String name);
	public Class getClass(int id);
	public void deleteClass(int id);
	public List<Class> getClasses();
    public List<Class> getClassesByStudent(Student s);
    public List<Class> getClassesByInstructor(Instructor i);
}
