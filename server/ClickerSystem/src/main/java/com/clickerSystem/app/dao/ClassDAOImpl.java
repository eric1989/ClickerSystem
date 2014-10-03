package com.clickerSystem.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clickerSystem.app.model.Class;

@Repository
public class ClassDAOImpl implements ClassDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void addClass(Class c){
		this.sessionFactory.getCurrentSession().save(c);
	}

	public void updateClass(Class c, String name){
		Class cToUpdate = getClass(c.getId());
		cToUpdate.setName(name);
		this.sessionFactory.getCurrentSession().update(cToUpdate);
	}
	public Class getClass(int id){
		Class c = (Class)this.sessionFactory.getCurrentSession().get(Class.class, id);
		return c;
	}
	public void deleteClass(int id){
		Class c = getClass(id);
		if (c != null) {
			this.sessionFactory.getCurrentSession().delete(c);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Class> getClasses(){
		return this.sessionFactory.getCurrentSession().createQuery("from Class").list();
	}
	
}
