package com.clickerSystem.app.dao;

import com.clickerSystem.app.model.GradeBook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by liqiang on 3/29/14.
 */
@Repository
public class GradeBookDAOImpl implements GradeBookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addGB(GradeBook c) {
        this.sessionFactory.getCurrentSession().save(c);
    }

    public void updateGB(GradeBook g, String Answer) {
        GradeBook gUpdate = getGB(g.getId());
        gUpdate.setAnswer(Answer);
        this.sessionFactory.getCurrentSession().update(gUpdate);
    }

    public GradeBook getGB(int id) {
        return (GradeBook) this.sessionFactory.getCurrentSession().get(GradeBook.class, id);
    }

    public void deleteGB(int id) {
        GradeBook gb = getGB(id);
        this.sessionFactory.getCurrentSession().delete(gb);
    }

    public void deleteGB(int classId, int questionNumber) {
        Date   current = new Date(new java.util.Date().getTime());
        String SQL = "from GradeBook where Class_Id = " + classId;
        SQL += " and QuestionNumber = " + questionNumber;
        SQL += " and submitDate = '" + current.toString() + "' ";
        List<GradeBook> res = this.sessionFactory.getCurrentSession().createQuery(SQL).list();
        for (GradeBook each : res) {
            deleteGB(each.getId());
        }
    }

    public List<GradeBook> getGBs() {
       return this.sessionFactory.getCurrentSession().createQuery("from GradeBook").list();
    }

    public int hasGB(GradeBook g) {
        String SQL = "from GradeBook where Student_Id = " + g.getStudent().getId();
        SQL = SQL + " and Class_Id = " + g.getClass1().getId();
        SQL = SQL + " and QuestionNumber = " + g.getQuestionNumber();
        SQL = SQL + " and submitDate = " + "'" + g.getSubmitDate().toString() + "'";
        System.out.println(SQL);
        List<GradeBook> res = this.sessionFactory.getCurrentSession().createQuery(SQL).list();
        if (res.size() > 0) {
            return res.get(0).getId();
        }
        return -1;
    }

    @Override
    public List<GradeBook> getCurrentGBs(int classId) {
        String SQL = "FROM GradeBook" + " WHERE class_id = " + Integer.toString(classId);
        Date   current = new Date(new java.util.Date().getTime());
        String sqlDate = "'" + current.toString() + "'";
        SQL = SQL + "and submitDate = " + sqlDate;
        return this.sessionFactory.getCurrentSession().createQuery(SQL).list();
    }


}
