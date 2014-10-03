package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.Enroll;
import com.clickerSystem.app.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liqiang on 4/1/14.
 */
@Repository
public class EnrollDAOImpl implements EnrollDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    public void addEnroll(Enroll e) {
         sessionFactory.getCurrentSession().save(e);
    }

    public Enroll getEnroll(int enrollId) {
        return (Enroll)sessionFactory.getCurrentSession().get(Enroll.class, enrollId);
    }

    public void deleteEnroll(int enrollId) {
         Enroll e = getEnroll(enrollId);
         sessionFactory.getCurrentSession().delete(enrollId);
    }

    @SuppressWarnings("unchecked")
    public List<Enroll> getEnrollsByStudent(Student s) {
        String SQL = "from Enroll Where Student_Id=" + s.getId().toString();
        return this.sessionFactory.getCurrentSession().createQuery(SQL).list();
//        Criteria cr = session.createCriteria(Enroll.class);
//        cr.add(Restrictions.eq("student", s));
//        List enrolls = cr.list();
//        List<Enroll> result = new ArrayList<Enroll>();
//        for (Iterator iterator = enrolls.iterator(); iterator.hasNext();) {
//              result.add((Enroll) iterator);
//        }
//        return result;
    }
}
