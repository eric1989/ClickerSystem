package com.clickerSystem.app.service;

import com.clickerSystem.app.model.Instructor;
import java.util.List;


public interface InstructorService {

	public void addInstructor(Instructor s);
	public void updateInstructor(Instructor s, String name, String password);
	public Instructor getInstructor(int id);
	public void deleteInstructor(int id);
	public List<Instructor> getInstructors();
}
