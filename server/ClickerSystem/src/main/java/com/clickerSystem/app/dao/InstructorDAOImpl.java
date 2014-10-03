package com.clickerSystem.app.dao;


import java.util.List;

import com.clickerSystem.app.model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDAOImpl implements InstructorDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void addInstructor(Instructor instructor){
		this.sessionFactory.getCurrentSession().save(instructor);
	}

	public void updateInstructor(Instructor instructor, String name, String password){
		Instructor instructorToUpdate = getInstructor(instructor.getId());
		instructorToUpdate.setName(name);
		instructorToUpdate.setPassword(password);
		this.sessionFactory.getCurrentSession().update(instructorToUpdate);
	}
	public Instructor getInstructor(int id){
		Instructor instructor = (Instructor)this.sessionFactory.getCurrentSession().get(Instructor.class, id);
		return instructor;
	}
	public void deleteInstructor(int id){
		Instructor instructor = getInstructor(id);
		if (instructor != null) {
			this.sessionFactory.getCurrentSession().delete(instructor);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Instructor> getInstructors(){
		return this.sessionFactory.getCurrentSession().createQuery("from Instructor").list();
	}
}
