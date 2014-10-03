package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.Teacher;
import com.clickerSystem.app.model.Instructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	public void addTeacher(Teacher t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public Teacher getTeacher(int teacherId) {
		return (Teacher)sessionFactory.getCurrentSession().get(Teacher.class, teacherId);
	}

	public void deleteTeacher(int teacherId) {
		Teacher t = getTeacher(teacherId);
		sessionFactory.getCurrentSession().delete(teacherId);
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getTeachersByInstructor(Instructor i) {
		String SQL = "from Teacher Where Instructor_Id=" + i.getId().toString();
		return this.sessionFactory.getCurrentSession().createQuery(SQL).list();
//        Criteria cr = session.createCriteria(Teacher.class);
//        cr.add(Restrictions.eq("student", s));
//        List Teachers = cr.list();
//        List<Teacher> result = new ArrayList<Teacher>();
//        for (Iterator iterator = Teachers.iterator(); iterator.hasNext();) {
//              result.add((Teacher) iterator);
//        }
//        return result;
	}
}
