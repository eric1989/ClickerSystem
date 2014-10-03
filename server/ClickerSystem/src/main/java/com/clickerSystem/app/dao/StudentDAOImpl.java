package com.clickerSystem.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clickerSystem.app.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student s){
		this.sessionFactory.getCurrentSession().save(s);
	}

	public void updateStudent(Student s, String name, String password){
		Student sToUpdate = getStudent(s.getId());
		sToUpdate.setName(name);
		sToUpdate.setPassword(password);
		this.sessionFactory.getCurrentSession().update(sToUpdate);
	}
	public Student getStudent(int id){
		Student s = (Student)this.sessionFactory.getCurrentSession().get(Student.class, id);
		return s;
	}
	public void deleteStudent(int id){
		Student s = getStudent(id);
		if (s != null) {
			this.sessionFactory.getCurrentSession().delete(s);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Student> getStudents(){
		return this.sessionFactory.getCurrentSession().createQuery("from Student").list();
	}
	
}
