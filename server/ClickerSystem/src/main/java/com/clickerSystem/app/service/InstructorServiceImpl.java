package com.clickerSystem.app.service;

import com.clickerSystem.app.dao.InstructorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickerSystem.app.model.Instructor;

import java.util.List;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService{
	@Autowired
	private InstructorDAO InstructorDAO;

	public void addInstructor(Instructor s){
		InstructorDAO.addInstructor(s);
	}
	public void updateInstructor(Instructor s, String name, String password){
		InstructorDAO.updateInstructor(s, name, password);
	}
	public Instructor getInstructor(int id){
		return (Instructor)InstructorDAO.getInstructor(id);
	}
	public void deleteInstructor(int id){
		InstructorDAO.deleteInstructor(id);
	}
	public List<Instructor> getInstructors(){
		return InstructorDAO.getInstructors();
	}
}
