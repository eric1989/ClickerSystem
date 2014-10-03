package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.Instructor;

import java.util.List;

/**
 * Created by rickieong on 3/30/14.
 */
public interface InstructorDAO {
	public void addInstructor(Instructor s);
	public void updateInstructor(Instructor s, String name, String password);
	public Instructor getInstructor(int id);
	public void deleteInstructor(int id);
	public List<Instructor> getInstructors();
}
