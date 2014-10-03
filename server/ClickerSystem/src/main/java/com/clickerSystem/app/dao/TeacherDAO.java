package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.Teacher;
import com.clickerSystem.app.model.Instructor;

import java.util.List;

public interface TeacherDAO {
	public void addTeacher(Teacher t);
	public void deleteTeacher(int teacherId);
	public Teacher getTeacher(int teacherId);
	public List<Teacher> getTeachersByInstructor(Instructor i);
}
